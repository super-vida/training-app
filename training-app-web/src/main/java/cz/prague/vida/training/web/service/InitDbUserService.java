package cz.prague.vida.training.web.service;

import static cz.prague.vida.training.Logger.logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.prague.vida.training.entity.User;
import cz.prague.vida.training.entity.Workout;
import cz.prague.vida.training.parser.GpxTrainingParser;
import cz.prague.vida.training.web.repository.UserRepository;
import cz.prague.vida.training.web.repository.WorkoutRepository;

@Service
public class InitDbUserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	WorkoutRepository workoutRepository;

	@PostConstruct
	public void init() {
		System.out.println("*** INIT DATABASE START ***");
			User user = new User();
			user.setFirstName("Jan");
			user.setLastName("Vacek");
			user.setUserName("vida");
			user.setEmail("vacek.honza@gamil.com");
			userRepository.save(user);
		
		System.out.println("*** INIT DATABASE FINISH ***");
		
		
		GpxTrainingParser gpxTrainingParser = new GpxTrainingParser();
		
		try {
			logger.info("\n----------------------------------------------\nStaring Training application");
			Workout workout = gpxTrainingParser.parse(user, "ride.gpx");
			logger.info("Closing Training application\n----------------------------------------------\n");
			workoutRepository.save(workout);
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public UserRepository getCheckRepo() {
		return userRepository;
	}

	public void setCheckRepo(UserRepository checkRepo) {
		this.userRepository = checkRepo;
	}

	

}
