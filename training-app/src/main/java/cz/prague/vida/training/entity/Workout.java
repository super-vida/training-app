package cz.prague.vida.training.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Workout {
	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	private Long duration;
	private Long motion;
	private BigDecimal distance;
	private Integer ascend;
	private BigDecimal averageSpeed;
	private Integer averageHeartRate;
	private Integer trimp;
	private Integer averageCadence;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public Long getMotion() {
		return motion;
	}
	public void setMotion(Long motion) {
		this.motion = motion;
	}
	public BigDecimal getDistance() {
		return distance;
	}
	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}
	public Integer getAscend() {
		return ascend;
	}
	public void setAscend(Integer ascend) {
		this.ascend = ascend;
	}
	public BigDecimal getAverageSpeed() {
		return averageSpeed;
	}
	public void setAverageSpeed(BigDecimal averageSpeed) {
		this.averageSpeed = averageSpeed;
	}
	public Integer getAverageHeartRate() {
		return averageHeartRate;
	}
	public void setAverageHeartRate(Integer averageHeartRate) {
		this.averageHeartRate = averageHeartRate;
	}
	public Integer getTrimp() {
		return trimp;
	}
	public void setTrimp(Integer trimp) {
		this.trimp = trimp;
	}
	public Integer getAverageCadence() {
		return averageCadence;
	}
	public void setAverageCadence(Integer averageCadence) {
		this.averageCadence = averageCadence;
	}
	@Override
	public String toString() {
		return "Workout [id=" + id + ", date=" + date + ", duration=" + duration + ", motion=" + motion + ", distance="
				+ distance + ", ascend=" + ascend + ", averageSpeed=" + averageSpeed + ", averageHeartRate="
				+ averageHeartRate + ", trimp=" + trimp + ", averageCadence=" + averageCadence + "]";
	}
	
	
	
	

}
