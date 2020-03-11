package cz.prague.vida.training.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cz.prague.vida.training.entity.User;
import cz.prague.vida.training.web.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void save(User check) {
		userRepository.save(check);
	}

	public void remove(User check) {
		userRepository.delete(check);
	}

}
