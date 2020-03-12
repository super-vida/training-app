package cz.prague.vida.training.tcx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Extensions
{
	@XmlElement(name = "TPX", namespace = "http://www.garmin.com/xmlschemas/ActivityExtension/v2")
    private TPX tpx;

	public TPX getTpx() {
		return tpx;
	}

	public void setTpx(TPX tpx) {
		this.tpx = tpx;
	}

	@Override
	public String toString() {
		return "Extensions [tpx=" + tpx + "]";
	}

   
}
