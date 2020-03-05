package cz.prague.vida.training.entity;

public class Metadata {
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ClassPojo [time = " + time + "]";
	}
}
