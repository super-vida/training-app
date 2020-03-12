package cz.prague.vida.training.tcx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
@XmlAccessorType(XmlAccessType.FIELD)
public class Activities
{
	@XmlElement(name = "Activity")
    private Activity activity;

    public Activity getActivity ()
    {
        return activity;
    }

    public void setActivity (Activity activity)
    {
        this.activity = activity;
    }

	@Override
	public String toString() {
		return "Activities [Activity=" + activity + "]";
	}

   
}
