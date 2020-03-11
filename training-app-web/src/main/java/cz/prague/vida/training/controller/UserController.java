package cz.prague.vida.training.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import cz.prague.vida.training.entity.User;
import cz.prague.vida.training.web.service.UserService;

@ManagedBean
@ViewScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{userService}")
	private UserService userService;

	private List<User> users;

	private User user = new User();

	@PostConstruct
	public void loadUsers() {
		users = userService.findAll();
	}

	public void save() {
		userService.save(user);
		user = new User();
		users = userService.findAll();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User saved!", null));
	}

	public void remove(User user) {
		userService.remove(user);
		users = userService.findAll();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User removed!", null));
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
