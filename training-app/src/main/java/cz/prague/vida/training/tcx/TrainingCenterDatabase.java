package cz.prague.vida.training.tcx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "TrainingCenterDatabase",  namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
public class TrainingCenterDatabase
{
	@XmlElement(name = "Activities")
    private Activities activities;

    private String xmlns;

    private Author Author;

    public Activities getActivities ()
    {
        return activities;
    }

    public void setActivities (Activities activities)
    {
        this.activities = activities;
    }

    public String getXmlns ()
    {
        return xmlns;
    }

    public void setXmlns (String xmlns)
    {
        this.xmlns = xmlns;
    }

    public Author getAuthor ()
    {
        return Author;
    }

    public void setAuthor (Author Author)
    {
        this.Author = Author;
    }

	@Override
	public String toString() {
		return "TrainingCenterDatabase [Activities=" + activities + ", xmlns=" + xmlns + ", Author=" + Author + "]";
	}

    
}
			
		
