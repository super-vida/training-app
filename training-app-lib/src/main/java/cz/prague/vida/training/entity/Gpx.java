package cz.prague.vida.training.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "http://www.topografix.com/GPX/1/1")
public class Gpx {
	@XmlAttribute
	private String creator;
	@XmlAttribute
	private String xmlns;

	private Metadata metadata;
    @XmlElement
	private Trk trk;
	@XmlAttribute
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
		return "Gpx [creator=" + creator + ", xmlns=" + xmlns + ", metadata=" + metadata + ", trk=" + trk + ", version=" + version + "]";
	}

}
