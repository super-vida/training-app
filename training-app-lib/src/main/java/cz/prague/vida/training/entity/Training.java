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

}