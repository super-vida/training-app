package cz.prague.vida.training.parser;

import static cz.prague.vida.training.Logger.logger;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import cz.prague.vida.training.entity.User;
import cz.prague.vida.training.entity.Workout;
import cz.prague.vida.training.tcx.Trackpoint;
import cz.prague.vida.training.tcx.TrainingCenterDatabase;

public class TcxTrainingParser extends Parser {

	private Trackpoint[] trackPoints;

	private Workout parse(TrainingCenterDatabase gpx) {
		trackPoints = gpx.getActivities().getActivity().getLap().getTrack().getTrackpoint();
		for (Trackpoint t : trackPoints) {
			makeTimeStatistics(t.getTime(), trackPoints.length);
			if (t.getPosition() != null) {
				makeDistanceStatistics(t.getPosition().getLatitudeDegrees(), t.getPosition().getLongitudeDegrees());
			}
			makeHeartRateStatistics(t.getHeartRateBpm().getValue());
			makeElevationStatistics(t.getAltitudeMeters());
			makeCadenceStatistics(t.getCadence());
			counter++;
		}
		Workout workout = populateWorkout();
		workout.setCalories(gpx.getActivities().getActivity().getLap().getCalories());
		workout.setDate(gpx.getActivities().getActivity().getId());
		return workout;
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
		//System.out.println(gpx);
		return parse(gpx);

	}

	public static void main(String[] args) throws Exception {

		TcxTrainingParser parser = new TcxTrainingParser();
		System.out.println(new TcxTrainingParser().parse(null, "ride1.tcx"));

		Files.walk(Paths.get("workouts")).filter(Files::isRegularFile).forEach(f -> {
			try {
				parser.parse(null, f.toString());
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
