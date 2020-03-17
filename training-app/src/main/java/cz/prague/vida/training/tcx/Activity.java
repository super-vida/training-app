package cz.prague.vida.training.tcx;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
@XmlAccessorType(XmlAccessType.FIELD)
public class Activity
{
	@XmlAttribute(name = "Sport")
    private String sport;
	@XmlElement(name = "Lap")
    private Lap lap;
	@XmlElement(name = "Id")
    private Date id;
	@XmlElement(name = "Creator")
    private Creator creator;

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public Lap getLap() {
		return lap;
	}

	public void setLap(Lap lap) {
		this.lap = lap;
	}

	public Date getId() {
		return id;
	}

	public void setId(Date id) {
		this.id = id;
	}

	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Activity [sport=" + sport + ", lap=" + lap + ", id=" + id + ", creator=" + creator + "]";
	}

   
   
}
			
