package cz.prague.vida.training.entity;

public class Trkseg {
	private Trkpt[] trkpt;

	public Trkpt[] getTrkpt() {
		return trkpt;
	}

	public void setTrkpt(Trkpt[] trkpt) {
		this.trkpt = trkpt;
	}

	@Override
	public String toString() {
		return "ClassPojo [trkpt = " + trkpt + "]";
	}
}
