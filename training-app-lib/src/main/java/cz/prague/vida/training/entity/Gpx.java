package cz.prague.vida.training.entity;

public class Gpx {
	private String creator;

	private String xmlns;

	private Metadata metadata;

	private Trk trk;

	private String version;

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getXmlns() {
		return xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public Trk getTrk() {
		return trk;
	}

	public void setTrk(Trk trk) {
		this.trk = trk;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "ClassPojo [creator = " + creator + ", xmlns = " + xmlns + ", metadata = " + metadata + ", trk = " + trk
				+ ", version = " + version + "]";
	}
}
