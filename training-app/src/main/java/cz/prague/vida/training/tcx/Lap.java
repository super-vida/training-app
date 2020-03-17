package cz.prague.vida.training.tcx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Lap {
	@XmlElement(name = "MaximumHeartRateBpm")
	private MaximumHeartRateBpm maximumHeartRateBpm;
	@XmlElement(name = "Intensity")
	private String intensity;
	@XmlAttribute(name = "StartTime")
	private String startTime;
	@XmlElement(name = "TriggerMethod")
	private String triggerMethod;
	@XmlElement(name = "TotalTimeSeconds")
	private String totalTimeSeconds;
	@XmlElement(name = "AverageHeartRateBpm")
	private AverageHeartRateBpm averageHeartRateBpm;
	@XmlElement(name = "Calories")
	private Integer calories;
	@XmlElement(name = "Track")
	private Track track;

	public MaximumHeartRateBpm getMaximumHeartRateBpm() {
		return maximumHeartRateBpm;
	}

	public void setMaximumHeartRateBpm(MaximumHeartRateBpm maximumHeartRateBpm) {
		this.maximumHeartRateBpm = maximumHeartRateBpm;
	}

	public String getIntensity() {
		return intensity;
	}

	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getTriggerMethod() {
		return triggerMethod;
	}

	public void setTriggerMethod(String triggerMethod) {
		this.triggerMethod = triggerMethod;
	}

	public String getTotalTimeSeconds() {
		return totalTimeSeconds;
	}

	public void setTotalTimeSeconds(String totalTimeSeconds) {
		this.totalTimeSeconds = totalTimeSeconds;
	}

	public AverageHeartRateBpm getAverageHeartRateBpm() {
		return averageHeartRateBpm;
	}

	public void setAverageHeartRateBpm(AverageHeartRateBpm averageHeartRateBpm) {
		this.averageHeartRateBpm = averageHeartRateBpm;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	@Override
	public String toString() {
		return "Lap [maximumHeartRateBpm=" + maximumHeartRateBpm + ", intensity=" + intensity + ", startTime="
				+ startTime + ", triggerMethod=" + triggerMethod + ", totalTimeSeconds=" + totalTimeSeconds
				+ ", averageHeartRateBpm=" + averageHeartRateBpm + ", calories=" + calories + ", track=" + track + "]\n";
	}

	
}
