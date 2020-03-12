package cz.prague.vida.training.parser;

import static cz.prague.vida.training.Logger.logger;

import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import cz.prague.vida.training.entity.TrainingStatistics;
import cz.prague.vida.training.entity.TrainingZone;
import cz.prague.vida.training.entity.User;
import cz.prague.vida.training.entity.Workout;
import cz.prague.vida.training.gpx.Trkpt;
import cz.prague.vida.training.tcx.Activities;
import cz.prague.vida.training.tcx.Trackpoint;
import cz.prague.vida.training.tcx.TrainingCenterDatabase;

public class TcxTrainingParser {

	private TrainingStatistics trainingStatistics = new TrainingStatistics();

	private Trackpoint[] trackPoints;

	private Instant startTime = null;
	private Instant finnishTime = null;
	private Instant lastTime = null;
	private long pausedTime = 0;
	private int gaps = 0;
	private int counter = 0;
	private double distance = 0;
	private double lastLatitude = 0;
	private double lastLongtitute = 0;
	private double heartRateSum = 0;
	private double maxHeartRate = 0;
	private double lastHeartRate = 0;
	private double ascend = 0;
	private double descend = 0;
	private double lastElevation = 0;
	private double trimp = 0;
	private Map<Double, Double> trimpMap = new HashMap<Double, Double>();
	private Map<TrainingZone, Double> zoneMap = new HashMap<TrainingZone, Double>();
	private Map<Double, List<Integer>> peakHeartRateMap = new HashMap<Double, List<Integer>>();

	private boolean paused;

	private User user;

	private double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		} else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
					+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}

	private void makeDistanceStatistics(Trackpoint t) {

		if (lastLatitude > 0) {
			double latitude = Double.parseDouble(t.getPosition().getLatitudeDegrees());
			double longtitute = Double.parseDouble(t.getPosition().getLongitudeDegrees());
			distance = distance + distance(lastLatitude, lastLongtitute, latitude, longtitute, "K");
		}
		lastLatitude = Double.parseDouble(t.getPosition().getLatitudeDegrees());
		lastLongtitute = Double.parseDouble(t.getPosition().getLongitudeDegrees());
	}

	private void makeHeartRateStatistics(Trackpoint t) {

		Double localHr = Double.valueOf(t.getHeartRateBpm().getValue());
		maxHeartRate = localHr > maxHeartRate ? localHr : maxHeartRate;
		Double timeInHeartRate = trimpMap.get(localHr);
		trimpMap.put(localHr, timeInHeartRate == null ? 1 : timeInHeartRate + 1);
		heartRateSum = heartRateSum + localHr;
		if (user != null && user.getTrainingZones() != null) {
			for (TrainingZone zone : user.getTrainingZones()) {
				if (localHr.intValue() > zone.getFrom().intValue() && localHr.intValue() <= zone.getTo().intValue() ) {
					if (zoneMap.containsKey(zone)) {
						double time = zoneMap.get(zone);
						zoneMap.put(zone, time + 1.0);
					} else {
						zoneMap.put(zone, 1.0);
					}
				}
			}
		}
		if (lastHeartRate > 0) {
			if (lastHeartRate == localHr) {
				if (peakHeartRateMap.containsKey(localHr)) {
					List<Integer> maxTimes = peakHeartRateMap.get(localHr);
					Integer lastMaxTime = maxTimes.get(maxTimes.size() - 1);
					maxTimes.set(maxTimes.size() -1 , lastMaxTime + 1);
					peakHeartRateMap.put(localHr, maxTimes);
				}
				else {
					List<Integer> maxTimes = new ArrayList<Integer>();
					maxTimes.add(1);
					peakHeartRateMap.put(localHr, maxTimes);
				}
			}
			else {
				List<Integer> maxTimes = peakHeartRateMap.get(localHr);
				if (maxTimes == null) {
					maxTimes = new ArrayList<Integer>();	
				}
				maxTimes.add(1);
				peakHeartRateMap.put(localHr, maxTimes);	
				
			}
		}
		lastHeartRate = localHr;
	}

	private void makeElevationStatistics(Trackpoint t) {

		if (lastElevation > 0) {
			double elevation = Double.parseDouble(t.getAltitudeMeters());
			if (elevation > lastElevation) {
				ascend = ascend + (elevation - lastElevation);
			}
			if (elevation < lastElevation) {
				descend = descend + (lastElevation - elevation);
			}
		}
		lastElevation = Double.parseDouble(t.getAltitudeMeters());

	}

	private void makeTimeStatistics(Trackpoint t) {

		if (startTime == null) {
			startTime = Instant.parse(t.getTime());
		}

		if (counter + 1 == trackPoints.length) {
			finnishTime = Instant.parse(t.getTime());
		}

		if (lastTime != null) {
			Duration duration = Duration.between(lastTime, Instant.parse(t.getTime()));
			if (duration.toMillis() > 2000) {
				pausedTime = pausedTime + duration.toMillis();
				gaps++;
				paused = true;
			} else {
				paused = false;
			}
		}
		lastTime = Instant.parse(t.getTime());

	}

	private void computeTrimp() {
		for (Map.Entry<Double, Double> entry : trimpMap.entrySet()) {
			trimp = trimp + (entry.getKey() * (entry.getValue() / 60.0));
		}
	}

	private Workout parse(TrainingCenterDatabase gpx) {
 trackPoints = gpx.getActivities().getActivity().getLap().getTrack().getTrackpoint();
        Workout workout = new Workout();
		for (Trackpoint t : trackPoints) {
			makeTimeStatistics(t);
			makeDistanceStatistics(t);
			makeHeartRateStatistics(t);
			makeElevationStatistics(t);
			counter++;
		}
		computeTrimp();
		Duration duration = Duration.between(startTime, finnishTime);
		trainingStatistics.setTotalTime(Math.abs(duration.toMillis()));
		trainingStatistics.setPausedTime(pausedTime);
		trainingStatistics.setGaps(gaps);
		trainingStatistics.setDistance(distance);
		trainingStatistics.setAverageHeartRate((int) (Math.ceil(heartRateSum / counter)));
		trainingStatistics.setMaximalHeartRate((int) maxHeartRate);
		trainingStatistics.setTrimp((int) trimp);
		trainingStatistics.setAscend((int) ascend);
		trainingStatistics.setDescend((int) descend);
		trainingStatistics.print();
		
		
		workout.setDate(new java.util.Date());
		workout.setDuration(duration.toMillis());
		workout.setMotion(duration.toMillis() - pausedTime);
		workout.setDistance(new BigDecimal(distance));
		workout.setAscend((int) ascend);
		workout.setAverageHeartRate((int) (Math.ceil(heartRateSum / counter)));
		workout.setTrimp((int) trimp);
		double time = (duration.toMillis() - pausedTime) / 1000.0 / 60.0 / 60.0 ;
		workout.setAverageSpeed(new BigDecimal(distance / time));

		for (Map.Entry<TrainingZone, Double> zone : zoneMap.entrySet()) {
			logger.info("Time in " + zone.getKey().getName() + " zone (" + zone.getKey().getFrom() + "-" + zone.getKey().getTo() + "): " + (zone.getValue() / 60.0));
		}
		
		List<Double> peakHeartRateList = new ArrayList<Double>(peakHeartRateMap.keySet());
		Collections.sort(peakHeartRateList);
		Collections.reverse(peakHeartRateList);
		time = 0;
		for(Double hr : peakHeartRateList) {
			List<Integer> list = peakHeartRateMap.get(hr);
			for (Integer max : list) {
				time = time + max;
			}
			
			//logger.info(""+ hr + ": " + (time > 3600 ? convertToHour((long)time) + " h" : time > 59 ? new DecimalFormat("#.##").format(time /60) + " m" : time + " s"));
			logger.info("" + convertSeconds((long) time) + ";" + hr.intValue());
		}
		return workout;
	}
	
	private String convertToHour(long totalTime) {
		long minutes = (totalTime / (60)) % 60;
		long hours = (totalTime / (60 * 60)) % 24;
		return hours + ":" + minutes;
	}
	
	private String convertSeconds(long totalTime) {
		long hours = totalTime / 3600;
		long minutes = (totalTime % 3600) / 60;
		long seconds = totalTime % 60;
		return new DecimalFormat("00").format(hours) + ":" + new DecimalFormat("00").format(minutes) + ":" + new DecimalFormat("00").format(seconds);
	}

	public Workout parse(User user, String fileName) throws Exception {
		logger.info("parsing...");
		this.user = user;
		FileReader fileReader = new FileReader(fileName);
		JAXBContext jaxbContext = JAXBContext.newInstance(TrainingCenterDatabase.class);
		XMLInputFactory xif = XMLInputFactory.newInstance();
		XMLStreamReader xsr = xif.createXMLStreamReader(fileReader);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		TrainingCenterDatabase gpx = (TrainingCenterDatabase) unmarshaller.unmarshal(xsr);
		System.out.println(gpx);
		return parse(gpx);

	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(new TcxTrainingParser().parse(null, "ride1.tcx"));
	}

}
