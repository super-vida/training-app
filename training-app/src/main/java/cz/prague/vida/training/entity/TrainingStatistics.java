package cz.prague.vida.training.entity;

import static cz.prague.vida.training.Logger.logger;

import java.text.DecimalFormat;

public class TrainingStatistics {

	private Integer ascend;
	private Integer descend;
	private Long totalTime;
	private Long pausedTime;
	private Integer gaps;
	private Integer averageHeartRate;
	private Integer maximalHeartRate;
	private Integer trimp;
	private Double distance;

	public Integer getAscend() {
		return ascend;
	}

	public void setAscend(Integer ascend) {
		this.ascend = ascend;
	}

	public Integer getDescend() {
		return descend;
	}

	public void setDescend(Integer descend) {
		this.descend = descend;
	}

	public Long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Long totalTime) {
		this.totalTime = totalTime;
	}

	public Long getPausedTime() {
		return pausedTime;
	}

	public void setPausedTime(Long pausedTime) {
		this.pausedTime = pausedTime;
	}

	public Integer getGaps() {
		return gaps;
	}

	public void setGaps(Integer gaps) {
		this.gaps = gaps;
	}

	public Integer getAverageHeartRate() {
		return averageHeartRate;
	}

	public void setAverageHeartRate(Integer averageHeartRate) {
		this.averageHeartRate = averageHeartRate;
	}

	public Integer getMaximalHeartRate() {
		return maximalHeartRate;
	}

	public void setMaximalHeartRate(Integer maximalHeartRate) {
		this.maximalHeartRate = maximalHeartRate;
	}

	public Integer getTrimp() {
		return trimp;
	}

	public void setTrimp(Integer trimp) {
		this.trimp = trimp;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public void print() {
		logger.info("Distance: " + new DecimalFormat("#.##").format(distance != null ? distance : 0));
		long minutes = (totalTime / (1000 * 60)) % 60;
		long hours = (totalTime / (1000 * 60 * 60)) % 24;
		logger.info("Complete time: " + hours + ":" + minutes);
		minutes = ((totalTime - pausedTime) / (1000 * 60)) % 60;
		hours = ((totalTime - pausedTime) / (1000 * 60 * 60)) % 24;
		logger.info("Duration in motion: " + hours + ":" + minutes);
		logger.info("Paused time: " + pausedTime / 1000 / 60);
		logger.info("Gaps: " + gaps);
		
		double time = (totalTime - pausedTime) / 1000.0 / 60.0 / 60.0 ;
		logger.info("Average speed: " + new DecimalFormat("#.##").format(distance != null ? distance / time : 0));
		logger.info("Average hear rate: " + averageHeartRate);
		logger.info("Maximum hear rate: " + maximalHeartRate);
		logger.info("TRIMP: " +  trimp);
		logger.info("Ascend: " + ascend);
		logger.info("Descend: " + descend);
	}
	
	

}
