package cz.prague.vida.training.tcx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Trackpoint
{
	@XmlElement(name = "HeartRateBpm")
    private HeartRateBpm heartRateBpm;
	@XmlElement(name = "Cadence")
    private Integer cadence;
	@XmlElement(name = "Position")
	private Position position;
	@XmlElement(name = "Time")
    private String time;
	@XmlElement(name = "AltitudeMeters")
	private String altitudeMeters;
	@XmlElement(name = "DistanceMeters")
    private String distanceMeters;
	@XmlElement(name = "Extensions")
    private Extensions extensions;
	public HeartRateBpm getHeartRateBpm() {
		return heartRateBpm;
	}
	public void setHeartRateBpm(HeartRateBpm heartRateBpm) {
		this.heartRateBpm = heartRateBpm;
	}
	public Integer getCadence() {
		return cadence;
	}
	public void setCadence(Integer cadence) {
		this.cadence = cadence;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Extensions getExtensions() {
		return extensions;
	}
	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getAltitudeMeters() {
		return altitudeMeters;
	}
	public void setAltitudeMeters(String altitudeMeters) {
		this.altitudeMeters = altitudeMeters;
	}
	public String getDistanceMeters() {
		return distanceMeters;
	}
	public void setDistanceMeters(String distanceMeters) {
		this.distanceMeters = distanceMeters;
	}
	@Override
	public String toString() {
		return "Trackpoint [heartRateBpm=" + heartRateBpm + ", cadence=" + cadence + ", position=" + position
				+ ", time=" + time + ", altitudeMeters=" + altitudeMeters + ", distanceMeters=" + distanceMeters
				+ ", extensions=" + extensions + "]";
	}
	

  

   
}
			
		
