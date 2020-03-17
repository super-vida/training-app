package cz.prague.vida.training.parser;

import static cz.prague.vida.training.Logger.logger;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import cz.prague.vida.training.entity.User;
import cz.prague.vida.training.entity.Workout;
import cz.prague.vida.training.gpx.Gpx;
import cz.prague.vida.training.gpx.Trkpt;

public class GpxTrainingParser extends Parser{

	private List<Trkpt> trackPoints;

	private Workout parse(Gpx gpx) {
		trackPoints = Arrays.asList(gpx.getTrk().getTrkseg().getTrkpt());
		for (Trkpt t : trackPoints) {
			makeTimeStatistics(t.getTime(), trackPoints.size());
			makeDistanceStatistics(t.getLat(), t.getLon());
			makeHeartRateStatistics(t.getExtensions().getTrackPointExtension().getHr());
			makeElevationStatistics(t.getEle());
			counter++;
		}
		return populateWorkout();
	}
	
	public Workout parse(User user, String fileName) throws Exception {
		logger.info("parsing...");
		this.user = user;
		FileReader fileReader = new FileReader(fileName);
		JAXBContext jaxbContext = JAXBContext.newInstance(Gpx.class);
		XMLInputFactory xif = XMLInputFactory.newInstance();
		XMLStreamReader xsr = xif.createXMLStreamReader(fileReader);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Gpx gpx = (Gpx) unmarshaller.unmarshal(xsr);
		return parse(gpx);

	}

}
