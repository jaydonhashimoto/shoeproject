/**
 * Class: HomeController
 * Objective: Direct user to landing page
 * 
 */
package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.UserBusinessInterface;
import com.gcu.model.Shoe;
import com.gcu.model.User;

@Controller
public class HomeController {
	
	UserBusinessInterface service;
	
	/**
	 * path to landing page
	 * @return String
	 */
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayLandingPage() {
		//return landing page
		return "landing";
	}
		
	/**
	 * path to home page
	 * @param user
	 * @return ModelAndView
	 */
	@RequestMapping(path="/home", method=RequestMethod.GET)
	public ModelAndView displayHome(@ModelAttribute("user") User user) {
		//return home page
		//if user is registered
		if(user != null) {
			user = service.getCurrentUser();
			//if admin, admin home
			if(user.getAdmin() == 1) {
				ModelAndView mv = new ModelAndView("adminHome");
				mv.addObject("shoe", new Shoe());
				mv.addObject("user", user);
				return mv;
			}
			//if not admin, home
			else
				return new ModelAndView("home", "user", user);
			//else, new user
		} else
			return new ModelAndView("home", "user", new User(0,"","","","",0));
	}
	
	/**
	 * path to contact page
	 * @return ModelAndView
	 */
	@RequestMapping(path="/contact", method=RequestMethod.GET)
	public ModelAndView displayContactPage() {
		//get current user
		User user = service.getCurrentUser();
		//return contact page with models
		ModelAndView mv = new ModelAndView("contactUs");
		mv.addObject("shoe", new Shoe());
		mv.addObject("user", user);
		return mv;
	}
	
	/**
	 * 	setter method
	 * @param service
	 * @return void
	 */
	@Autowired
	public void setUserBusinessService(UserBusinessInterface service)
	{
		this.service = service;
	}
}