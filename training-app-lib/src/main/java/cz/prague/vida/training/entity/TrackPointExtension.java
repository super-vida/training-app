package cz.prague.vida.training.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://www.garmin.com/xmlschemas/TrackPointExtension/v1")
public class TrackPointExtension {

	private String hr;

	public String getHr() {
		return hr;
	}

	public void setHr(String hr) {
		this.hr = hr;
	}

	@Override
	public String toString() {
		return "TrackPointExtension [hr=" + hr + "]";
	}

}
