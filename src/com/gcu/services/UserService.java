package com.gcu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.UserBusinessInterface;
import com.gcu.model.User;

/**
 * REST service class
 * @author jaydon
 *
 */
@RestController()
@RequestMapping("service")
public class UserService {
	
	@Autowired
	UserBusinessInterface service;
	
	/**
	 * REST method to return all users
	 * @return users
	 */
	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> users = service.getAllUsers();
		return users;
	}
}
