package cz.prague.vida.training.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import cz.prague.vida.training.web.service.HelloSpringService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
public class HelloController {
	
	@ManagedProperty("#{helloSpringService}")
	private HelloSpringService helloSpringService;
	
	public String showHello() {
		return helloSpringService.sayHello();
	}
	
	public void setHelloSpringService(HelloSpringService helloSpringService) {
		this.helloSpringService = helloSpringService;
	}

}
