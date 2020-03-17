package cz.prague.vida.training.parser;

import static cz.prague.vida.training.Logger.logger;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.prague.vida.training.entity.TrainingZone;
import cz.prague.vida.training.entity.User;
import cz.prague.vida.training.entity.Workout;

public class Parser {

	protected Instant startTime = null;
	protected Instant finnishTime = null;
	protected Instant lastTime = null;
	protected long pausedTime = 0;
	protected int gaps = 0;
	protected int counter = 0;
	protected double distance = 0;
	protected double lastLatitude = 0;
	protected double lastLongtitute = 0;
	protected double heartRateSum = 0;
	protected int cadenceSum = 0;
	protected int cadenceMax = 0;
	protected double maxHeartRate = 0;
	protected double lastHeartRate = 0;
	protected double ascend = 0;
	protected double descend = 0;
	protected double lastElevation = 0;
	protected double trimp = 0;
	protected Map<Double, Double> trimpMap = new HashMap<Double, Double>();
	protected Map<TrainingZone, Double> zoneMap = new HashMap<TrainingZone, Double>();
	protected Map<Double, List<Integer>> peakHeartRateMap = new HashMap<Double, List<Integer>>();

	protected boolean paused;

	protected User user;

	protected double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			}
			else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}

	protected void makeHeartRateStatistics(String heartRate) {

		Double localHr = Double.valueOf(heartRate);
		maxHeartRate = localHr > maxHeartRate ? localHr : maxHeartRate;
		Double timeInHeartRate = trimpMap.get(localHr);
		trimpMap.put(localHr, timeInHeartRate == null ? 1 : timeInHeartRate + 1);
		heartRateSum = heartRateSum + localHr;
		if (user != null && user.getTrainingZones() != null) {
			for (TrainingZone zone : user.getTrainingZones()) {
				if (localHr.intValue() > zone.getFrom().intValue() && localHr.intValue() <= zone.getTo().intValue()) {
					if (zoneMap.containsKey(zone)) {
						double time = zoneMap.get(zone);
						zoneMap.put(zone, time + 1.0);
					}
					else {
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
					maxTimes.set(maxTimes.size() - 1, lastMaxTime + 1);
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

	protected void makeCadenceStatistics(Integer cadence) {
		if (cadence != null) {
			cadenceSum = cadenceSum + cadence;
			cadenceMax = cadence > cadenceMax ? cadence : cadenceMax;
		}

	}

	protected void makeTimeStatistics(String time, int size) {

		if (startTime == null) {
			startTime = Instant.parse(time);
		}

		if (counter + 1 == size) {
			finnishTime = Instant.parse(time);
		}

		if (lastTime != null) {
			Duration duration = Duration.between(lastTime, Instant.parse(time));
			if (duration.toMillis() > 2000) {
				pausedTime = pausedTime + duration.toMillis();
				gaps++;
				paused = true;
			}
			else {
				paused = false;
			}
		}
		lastTime = Instant.parse(time);

	}

	protected void makeElevationStatistics(String altitudeMeters) {
		if (altitudeMeters != null) {
			if (lastElevation > 0) {
				double elevation = Double.parseDouble(altitudeMeters);
				if (elevation > lastElevation) {
					ascend = ascend + (elevation - lastElevation);
				}
				if (elevation < lastElevation) {
					descend = descend + (lastElevation - elevation);
				}
			}
			lastElevation = Double.parseDouble(altitudeMeters);
		}
	}

	protected void makeDistanceStatistics(String latitudeDegree, String longitudeDegrees) {
		if (latitudeDegree != null && longitudeDegrees != null) {

			if (lastLatitude > 0) {
				double latitude = Double.parseDouble(latitudeDegree);
				double longtitute = Double.parseDouble(longitudeDegrees);
				distance = distance + distance(lastLatitude, lastLongtitute, latitude, longtitute, "K");
			}
			lastLatitude = Double.parseDouble(latitudeDegree);
			lastLongtitute = Double.parseDouble(longitudeDegrees);
		}
	}

	protected void computeTrimp() {
		for (Map.Entry<Double, Double> entry : trimpMap.entrySet()) {
			trimp = trimp + (entry.getKey() * (entry.getValue() / 60.0));
		}
	}

	private String convertSeconds(long totalTime) {
		long hours = totalTime / 3600;
		long minutes = (totalTime % 3600) / 60;
		long seconds = totalTime % 60;
		return new DecimalFormat("00").format(hours) + ":" + new DecimalFormat("00").format(minutes) + ":" + new DecimalFormat("00").format(seconds);
	}

	protected Workout populateWorkout() {
		Workout workout = new Workout();
		computeTrimp();
		Duration duration = Duration.between(startTime, finnishTime);
		workout.setDate(new java.util.Date());
		workout.setDuration(duration.toMillis());
		workout.setMotion(duration.toMillis() - pausedTime);
		workout.setDistance(new BigDecimal(distance));
		workout.setAscend((int) ascend);
		workout.setAverageHeartRate((int) (Math.ceil(heartRateSum / counter)));
		workout.setMaxHeartRate((int) Math.ceil(maxHeartRate));
		workout.setCadenceAvg(cadenceSum / counter);
		workout.setCadenceMax(cadenceMax);
		workout.setTrimp((int) trimp);
		workout.setGaps(gaps);
		double time = (duration.toMillis() - pausedTime) / 1000.0 / 60.0 / 60.0;
		workout.setAverageSpeed(new BigDecimal(distance / time));

		for (Map.Entry<TrainingZone, Double> zone : zoneMap.entrySet()) {
			logger.info("Time in " + zone.getKey().getName() + " zone (" + zone.getKey().getFrom() + "-" + zone.getKey().getTo() + "): " + (zone.getValue() / 60.0));
		}

		List<Double> peakHeartRateList = new ArrayList<Double>(peakHeartRateMap.keySet());
		Collections.sort(peakHeartRateList);
		Collections.reverse(peakHeartRateList);
		time = 0;
		for (Double hr : peakHeartRateList) {
			List<Integer> list = peakHeartRateMap.get(hr);
			for (Integer max : list) {
				time = time + max;
			}

			// logger.info(""+ hr + ": " + (time > 3600 ? convertToHour((long)time) + " h" : time > 59 ? new
			// DecimalFormat("#.##").format(time /60) + " m" : time + " s"));
			logger.info("" + convertSeconds((long) time) + ";" + hr.intValue());
		}

		return workout;
	}

}
