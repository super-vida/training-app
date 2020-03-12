package cz.prague.vida.training.tcx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Version
{
	@XmlElement(name = "VersionMinor")
    private String versionMinor;
	@XmlElement(name = "BuildMinor")
    private String buildMinor;
	@XmlElement(name = "VersionMajor")
    private String versionMajor;
	@XmlElement(name = "BuildMajor")
    private String buildMajor;
	public String getVersionMinor() {
		return versionMinor;
	}
	public void setVersionMinor(String versionMinor) {
		this.versionMinor = versionMinor;
	}
	public String getBuildMinor() {
		return buildMinor;
	}
	public void setBuildMinor(String buildMinor) {
		this.buildMinor = buildMinor;
	}
	public String getVersionMajor() {
		return versionMajor;
	}
	public void setVersionMajor(String versionMajor) {
		this.versionMajor = versionMajor;
	}
	public String getBuildMajor() {
		return buildMajor;
	}
	public void setBuildMajor(String buildMajor) {
		this.buildMajor = buildMajor;
	}
	@Override
	public String toString() {
		return "Version [versionMinor=" + versionMinor + ", buildMinor=" + buildMinor + ", versionMajor=" + versionMajor
				+ ", buildMajor=" + buildMajor + "]";
	}

   
}
			
