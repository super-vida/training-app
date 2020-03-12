package cz.prague.vida.training.tcx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
@XmlAccessorType(XmlAccessType.FIELD)
public class Track
{
	@XmlElement(name = "Trackpoint")
    private Trackpoint[] trackpoint;

	public Trackpoint[] getTrackpoint() {
		return trackpoint;
	}

	public void setTrackpoint(Trackpoint[] trackpoint) {
		this.trackpoint = trackpoint;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (trackpoint != null) {
			for (Trackpoint trackpoint2 : trackpoint) {
				sb.append(trackpoint2);
				sb.append("\n");
			}
		}
		return sb.toString();

	}

   
}
