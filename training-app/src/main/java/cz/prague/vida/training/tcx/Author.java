package cz.prague.vida.training.tcx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Author
{
	@XmlElement(name = "LangID")
    private String langID;
	@XmlElement(name = "PartNumber")
    private String partNumber;
	@XmlElement(name = "Build")
    private Build build;
	@XmlElement(name = "Name")
    private String name;
	public String getLangID() {
		return langID;
	}
	public void setLangID(String langID) {
		this.langID = langID;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public Build getBuild() {
		return build;
	}
	public void setBuild(Build build) {
		this.build = build;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Author [langID=" + langID + ", partNumber=" + partNumber + ", build=" + build + ", name=" + name + "]";
	}

   
}
			
