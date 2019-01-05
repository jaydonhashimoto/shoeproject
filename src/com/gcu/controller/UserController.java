/**
 * Class: UserController
 * Objective: Controls all the action associated with the user
 * 
 */
package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.business.UserBusinessInterface;
import com.gcu.model.User;
import com.gcu.util.UserNotFoundException;

@Controller
@RequestMapping("/user")
public class UserController {
	
	UserBusinessInterface service;
	ProductBusinessInterface interf;
	
	/**
	 * path to register page
	 * @return user registration page
	 */
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public ModelAndView displayRegisterForm() {
		
		return new ModelAndView("registerUser", "user", new User(0,"","","","",0));
	}
	
	
	/**
	 * path to register page
	 * @return User login page
	 */
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public ModelAndView displayLoginForm() {
		//upon logout/new login, set all properties to null
		if(service.getCurrentUser() != null) {
			User u = service.getCurrentUser();
			u.setId(0);
			u.setFirstName(null);
			u.setLastName(null);
			u.setEmail(null);
			u.setPassword(null);
			u.setAdmin(0);
		}
		//return loginUser with new user
		return new ModelAndView("loginUser", "user", new User(0,"","","","",0));
	}
	
	/**
	 * method to login user. This take email and password as an argument and check user's credential based on those entries. If the email and 
     * password is not found. It will throw UserNotFoundException. If true, user will be directed toward home page 
	 * @param user
	 * @return Home page
	 */
	@RequestMapping(path="/loginUser", method=RequestMethod.POST)
	public ModelAndView loginUser(@ModelAttribute("user") User user)
	{
		//try block to check if use exist
		try {
			service.findUser(user);
			//catching user not found exception and directing to error page
		} catch (UserNotFoundException e) {
		
			System.out.println("caught no user found");
			ModelAndView mv = new ModelAndView("loginUser");
			mv.addObject("user",user);
			mv.addObject("error","Could not find user. Please check user name and password");
			return mv;
		}
		
		{
			user = service.getUser(user);
			//if user is not admin, go to home
			if(service.getUser(user).getAdmin() == 0)
				return new ModelAndView("home", "user", user);
			//if admin, return admin home
			else {
				return new ModelAndView("redirect:/shoe/add");
			}
		}
		//if new user, return login page
		
	}
	
	/**
	 * This is a method to register user. It takes email and password as an argument.
	 *	It also does data validation to make sure the entire as per specified standard
	 * @param user
	 * @param result
	 * @return login page
	 */
	@RequestMapping(path="/registerUser", method=RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		//form submit and display the posted user data
		//validate form
		if(result.hasErrors()) {
			return new ModelAndView("registerUser", "user", user);
		}
		
		//if user is a duplicate, return duplicate user page
		if(service.isDublicate(user))
		{
			return new ModelAndView("duplicateUsers", "user", user);
		}
		//if not duplicate, insertUser()
		else service.insertUser(user);
		
		//return login page
		return new ModelAndView("loginUser", "user", user);
	}

/**
 * 	setter method
 * @param service
 */
	@Autowired
	public void setUserBusinessService(UserBusinessInterface service)
	{
		this.service = service;
	}
	
	
}