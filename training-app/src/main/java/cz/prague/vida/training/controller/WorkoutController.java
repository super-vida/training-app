package cz.prague.vida.training.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cz.prague.vida.training.entity.Workout;
import cz.prague.vida.training.web.service.WorkoutService;

@Named("workoutController")
@ViewScoped
public class WorkoutController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private WorkoutService workoutService;

	private List<Workout> workouts;

	private Workout user = new Workout();

	@PostConstruct
	public void loadWorkouts() {
		workouts = workoutService.findAll();
	}

	public void save() {
		workoutService.save(user);
		user = new Workout();
		workouts = workoutService.findAll();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Workout saved!", null));
	}

	public void remove(Workout workout) {
		workoutService.remove(workout);
		workouts = workoutService.findAll();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Workout removed!", null));
	}

	public WorkoutService getWorkoutService() {
		return workoutService;
	}

	public void setWorkoutService(WorkoutService workoutService) {
		this.workoutService = workoutService;
	}

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workout> workout) {
		this.workouts = workout;
	}

	public Workout getWorkout() {
		return user;
	}

	public void setWorkout(Workout workout) {
		this.user = workout;
	}

}
