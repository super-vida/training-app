package cz.prague.vida.training.tcx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Creator
{
	@XmlElement(name = "UnitId")
    private String unitId;
	@XmlElement(name = "Version")
    private Version version;
	@XmlElement(name = "ProductID")
    private String productID;
	@XmlElement(name = "Name")
    private String name;
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Creator [unitId=" + unitId + ", version=" + version + ", productID=" + productID + ", name=" + name
				+ "]";
	}

    
}
			
