package cz.prague.vida.training.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import cz.prague.vida.training.enums.SportType;

@Entity
public class Workout {
	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	private SportType sport = SportType.Cycling;
	private Long duration;
	private Long motion;
	private BigDecimal distance;
	private Integer ascend;
	private BigDecimal speedAvg;
	private Integer heartRateAvg;
	protected Integer heartRateMax;
	private Integer trimp;
	private Integer cadenceAvg;
	private Integer cadenceMax;
	private Integer calories;
	protected Integer gaps;
	
	

	public BigDecimal getSpeedAvg() {
		return speedAvg;
	}

	public void setSpeedAvg(BigDecimal speedAvg) {
		this.speedAvg = speedAvg;
	}

	public Integer getHeartRateAvg() {
		return heartRateAvg;
	}

	public void setHeartRateAvg(Integer heartRateAvg) {
		this.heartRateAvg = heartRateAvg;
	}

	public Integer getHeartRateMax() {
		return heartRateMax;
	}

	public void setHeartRateMax(Integer heartRateMax) {
		this.heartRateMax = heartRateMax;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	

	public Integer getGaps() {
		return gaps;
	}

	public void setGaps(Integer gaps) {
		this.gaps = gaps;
	}

	public SportType getSport() {
		return sport;
	}

	public void setSport(SportType sport) {
		this.sport = sport;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

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


	public Integer getTrimp() {
		return trimp;
	}

	public void setTrimp(Integer trimp) {
		this.trimp = trimp;
	}

	
	public Integer getCadenceAvg() {
		return cadenceAvg;
	}

	public void setCadenceAvg(Integer cadenceAvg) {
		this.cadenceAvg = cadenceAvg;
	}

	public Integer getCadenceMax() {
		return cadenceMax;
	}

	public void setCadenceMax(Integer cadenceMax) {
		this.cadenceMax = cadenceMax;
	}

	@Override
	public String toString() {
		return "Workout [id=" + id + ", date=" + date + ", sport=" + sport + ", duration=" + duration + ", motion="
				+ motion + ", distance=" + distance + ", ascend=" + ascend + ", speedAvg=" + speedAvg
				+ ", heartRateAvg=" + heartRateAvg + ", heartRateMax=" + heartRateMax + ", trimp=" + trimp
				+ ", cadenceAvg=" + cadenceAvg + ", cadenceMax=" + cadenceMax + ", calories=" + calories + ", gaps="
				+ gaps + "]";
	}

	

	

}
