package cz.prague.vida.training.entity;

public class Trk {
	private Trkseg trkseg;

	private String name;

	private String type;

	public Trkseg getTrkseg() {
		return trkseg;
	}

	public void setTrkseg(Trkseg trkseg) {
		this.trkseg = trkseg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Trk [trkseg=" + trkseg + ", name=" + name + ", type=" + type + "]\n";
	}

}
