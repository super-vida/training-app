package cz.prague.vida.training.entity;

import java.util.Arrays;

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
		return "Trkseg [trkpt=" + Arrays.toString(trkpt) + "]";
	}

}
