package cz.prague.vida.training.entity;

public class Trkpt {
	private String extensions;

	private String lon;

	private String time;

	private String lat;

	private String ele;

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
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
		return "ClassPojo [extensions = " + extensions + ", lon = " + lon + ", time = " + time + ", lat = " + lat
				+ ", ele = " + ele + "]";
	}
}
