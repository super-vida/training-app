package cz.prague.vida.training.web.service;

import org.springframework.stereotype.Service;

@Service
public class HelloSpringService {

	public String sayHello() {
		return "hello from spring service";
	}
}
