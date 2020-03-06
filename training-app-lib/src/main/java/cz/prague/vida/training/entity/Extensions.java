package cz.prague.vida.training.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Extensions {

	@XmlElement(name = "TrackPointExtension", namespace = "http://www.garmin.com/xmlschemas/TrackPointExtension/v1")
	private TrackPointExtension trackPointExtension;

	public TrackPointExtension getTrackPointExtension() {
		return trackPointExtension;
	}

	public void setTrackPointExtension(TrackPointExtension trackPointExtension) {
		this.trackPointExtension = trackPointExtension;
	}

	@Override
	public String toString() {
		return "Extensions [trackPointExtension=" + trackPointExtension + "]";
	}

	

}
