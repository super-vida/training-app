package cz.prague.vida.training.web.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.prague.vida.training.entity.User;
import cz.prague.vida.training.web.repository.UserRepository;

@Service
public class InitDbUserService {

	@Autowired
	UserRepository userRepository;

	@PostConstruct
	public void init() {
		System.out.println("*** INIT DATABASE START ***");
		{
			User user = new User();
			user.setFirstName("Jan");
			user.setLastName("Vacek");
			user.setUserName("vida");
			user.setEmail("vacek.honza@gamil.com");
			userRepository.save(user);
		}
		
		System.out.println("*** INIT DATABASE FINISH ***");
	}

	public UserRepository getCheckRepo() {
		return userRepository;
	}

	public void setCheckRepo(UserRepository checkRepo) {
		this.userRepository = checkRepo;
	}

	

}
