package cz.prague.vida.training.tcx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Position
{
	@XmlElement(name = "LatitudeDegrees")
    private String latitudeDegrees;
	@XmlElement(name = "LongitudeDegrees")
    private String longitudeDegrees;
	public String getLatitudeDegrees() {
		return latitudeDegrees;
	}
	public void setLatitudeDegrees(String latitudeDegrees) {
		this.latitudeDegrees = latitudeDegrees;
	}
	public String getLongitudeDegrees() {
		return longitudeDegrees;
	}
	public void setLongitudeDegrees(String longitudeDegrees) {
		this.longitudeDegrees = longitudeDegrees;
	}
	@Override
	public String toString() {
		return "Position [latitudeDegrees=" + latitudeDegrees + ", longitudeDegrees=" + longitudeDegrees + "]";
	}

   
}
