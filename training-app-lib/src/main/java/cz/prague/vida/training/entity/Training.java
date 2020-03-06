package cz.prague.vida.training.entity;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Optional;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

public class Training {
	private Gpx gpx;

	public Gpx getGpx() {
		return gpx;
	}

	public void setGpx(Gpx gpx) {
		this.gpx = gpx;
	}

	@Override
	public String toString() {
		return "ClassPojo [gpx = " + gpx + "]";
	}

	public static void main(String[] args) throws Exception {

		FileReader fileReader = new FileReader("ride.gpx");
		JAXBContext jaxbContext = JAXBContext.newInstance(Gpx.class);
		XMLInputFactory xif = XMLInputFactory.newInstance();
		XMLStreamReader xsr = xif.createXMLStreamReader(fileReader);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Gpx gpx = (Gpx) unmarshaller.unmarshal(xsr);
		// System.out.println(gpx);

		int count = 0;
		double hr = 0;
		for (Trkpt t : gpx.getTrk().getTrkseg().getTrkpt()) {
			count++;
			double localHr = Integer.parseInt(t.getExtensions().getTrackPointExtension().getHr());
			hr = hr + localHr;
		}

		System.out.println("Average hear rate: " +  (int)(Math.ceil(hr / count)));

		Stream<Trkpt> stream = Arrays.stream(gpx.getTrk().getTrkseg().getTrkpt());
		long elementCount = stream.count();
		stream = Arrays.stream(gpx.getTrk().getTrkseg().getTrkpt());
		Optional<Trkpt> trkptStart = stream.findFirst();
		stream = Arrays.stream(gpx.getTrk().getTrkseg().getTrkpt());
		Trkpt trkptEnd = stream.skip(elementCount - 1).findFirst().get();
		Instant startTime = Instant.parse(trkptStart.get().getTime());
		Instant endTime = Instant.parse(trkptEnd.getTime());

		Duration duration = Duration.between(startTime, endTime);
		long diff = Math.abs(duration.toMinutes());
		
		long hours = diff / 60; //since both are ints, you get an int
		long minutes = diff % 60;
		System.out.printf("Complete time: " + "%d:%02d", hours, minutes);

		

		Calendar lastDate = Calendar.getInstance();
		for (Trkpt t : gpx.getTrk().getTrkseg().getTrkpt()) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(t.getTime()));
			if (cal.getTimeInMillis() - lastDate.getTimeInMillis() > 2000) {
//				System.out.println(lastDate.getTime());
//				System.out.println(cal.getTime());
			}
			// lastDate.setTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(t.getTime()));
		}

	}

}