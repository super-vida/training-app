package cz.prague.vida.training.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cz.prague.vida.training.entity.Workout;
import cz.prague.vida.training.web.repository.WorkoutRepository;

@Service
public class WorkoutService {

	@Autowired
	private WorkoutRepository workoutRepository;
	
	public List<Workout> findAll() {
		return workoutRepository.findAll();
	}

	public void save(Workout workout) {
		workoutRepository.save(workout);
	}

	public void remove(Workout workout) {
		workoutRepository.delete(workout);
	}

}
