package cz.prague.vida.training.gpx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Trkpt {
	
	private Extensions extensions;

	@XmlAttribute
	private String lon;
	private String time;
	@XmlAttribute
	private String lat;
	private String ele;

	public Extensions getExtensions() {
		return extensions;
	}

	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getEle() {
		return ele;
	}

	public void setEle(String ele) {
		this.ele = ele;
	}

	@Override
	public String toString() {
		return "Trkpt [extensions=" + extensions + ", lon=" + lon + ", time=" + time + ", lat=" + lat + ", ele=" + ele + "]\n";
	}

}
