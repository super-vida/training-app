package cz.prague.vida.training.tcx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Build
{
	@XmlElement(name = "Type")
    private String type;
	@XmlElement(name = "Version")
    private Version version;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Build [type=" + type + ", version=" + version + "]";
	}

}
	
