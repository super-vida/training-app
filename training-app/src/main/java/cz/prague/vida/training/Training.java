package cz.prague.vida.training;

import cz.prague.vida.training.gpx.Gpx;

public class Training {
	private Gpx gpx;

	public Gpx getGpx() {
		return gpx;
	}

	public void setGpx(Gpx gpx) {
		this.gpx = gpx;
	}

	@Override
	public String toString() {
		return "ClassPojo [gpx = " + gpx + "]";
	}

}