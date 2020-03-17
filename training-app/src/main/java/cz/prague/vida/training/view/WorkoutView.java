package cz.prague.vida.training.view;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.primefaces.model.chart.PieChartModel;

import cz.prague.vida.training.entity.Workout;

@Named("workoutView")
@ViewScoped
public class WorkoutView {

	private Workout selectedWorkout;
	
	 private DashboardModel model;
	 
	 private PieChartModel pieModel1;
     

	public Workout getSelectedWorkout() {
		return selectedWorkout;
	}

	public void setSelectedWorkout(Workout selectedWorkout) {
		this.selectedWorkout = selectedWorkout;
	}

	public void onRowSelect(SelectEvent<Workout> event) {
		FacesMessage msg = new FacesMessage("Car Selected", event.getObject().getId().toString());
		setSelectedWorkout(event.getObject());
		 try {
			 model = new DefaultDashboardModel();
			 DashboardColumn column1 = new DefaultDashboardColumn();
		        DashboardColumn column2 = new DefaultDashboardColumn();
		        DashboardColumn column3 = new DefaultDashboardColumn();
		        DashboardColumn column4 = new DefaultDashboardColumn();
		        DashboardColumn column5 = new DefaultDashboardColumn();
		        DashboardColumn column6 = new DefaultDashboardColumn();
		         
		        column1.addWidget("duration");
		        column2.addWidget("motion");
		         
		        column3.addWidget("distance");
		        column4.addWidget("ascend");
		         
		        column5.addWidget("speed");
		        column6.addWidget("heartRate");
		        
		        column1.addWidget("trimp");
		        column2.addWidget("calories");
		        column3.addWidget("gaps");
		        column4.addWidget("cadence");
		 
		        model.addColumn(column1);
		        model.addColumn(column2);
		        model.addColumn(column3);
		        model.addColumn(column4);
		        model.addColumn(column5);
		        model.addColumn(column6);
		        
		        createPieModel1();
		        
		        
			FacesContext.getCurrentInstance().getExternalContext().redirect("workout.xhtml");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	private void createPieModel1() {
        pieModel1 = new PieChartModel();
 
        pieModel1.set("Z1", 540);
        pieModel1.set("Z2", 325);
        pieModel1.set("Z3", 702);
        pieModel1.set("Z4", 421);
        pieModel1.set("Z5a", 500);
        pieModel1.set("Z5b", 600);
        pieModel1.set("Z5c", 700);
        
 
        pieModel1.setTitle("Heart Rate Zones");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(false);
    }
 
   
 
	
	 public DashboardModel getModel() {
	        return model;
	    }

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	 

}
