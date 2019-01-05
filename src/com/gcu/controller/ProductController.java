/**
 * Class: ProductController
 * Objective: Controller all the action associated with the product
 * 
 */
package com.gcu.controller;

import java.util.List;

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
import com.gcu.model.Shoe;
import com.gcu.model.User;

@Controller
@RequestMapping("/shoe")
public class ProductController {
	ProductBusinessInterface interf;
	UserBusinessInterface service;
	
	/**
	 * path to admin home
	 * 
	 *
	 * @return admin home page
	 */
	@RequestMapping(path="/add", method=RequestMethod.GET)
	public ModelAndView displayRegisterForm() {		
		//return admin home page with shoe model
		User user = service.getCurrentUser();
		ModelAndView mv = new ModelAndView("adminHome");
		mv.addObject("shoe", new Shoe());
		mv.addObject("user", user);
		return mv;
	}
	
	/**
	 * method to receive and passe new shoe to insertShoe()
	 * @param shoe
	 * @param result
	 * @return ModelAndView
	 */
	@RequestMapping(path="/addproduct", method=RequestMethod.POST)
	public ModelAndView registerProduct(@Valid @ModelAttribute("shoe") Shoe shoe, BindingResult result) {
		//form submit and display the posted user data
		//validate form
		User user = service.getCurrentUser();
		ModelAndView mv = new ModelAndView("adminHome");
		mv.addObject("shoe", shoe);
		mv.addObject("user", user);
		if(result.hasErrors()) {
			return mv;
		}
		
		//if shoe creation was successful, return to admin page
		if(interf.insertShoe(shoe))
		{
			return mv;		
		}
		else 
		{
			System.out.println("Failed to insert shoe");
			return mv;
		}
	}
	
	/**
	 * method to pass shoe to update page
	 * @param shoe
	 * @return ModelAndView
	 */
	@RequestMapping(path="/update", method=RequestMethod.POST)
	public ModelAndView displayUpdateForm(@ModelAttribute("shoe") Shoe shoe) {		
		//return update shoe page
		User user = service.getCurrentUser();
		ModelAndView mv = new ModelAndView("updateShoe");
		mv.addObject("shoe", shoe);
		mv.addObject("user", user);
		return mv;
	}
	
	/**
	 * method to call updateShoe() and redirect to view shoes page
	 * @param shoe
	 * @param result
	 * @return String
	 */
	@RequestMapping(path="/updateproduct", method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("shoe") Shoe shoe, BindingResult result) {	
		//if shoe update is successful, go to view page
		if(interf.updateShoe(shoe))
		{
			return "redirect:view";
		}
		//else, go to view page
		else 
		{
			System.out.println("Failed to update shoe");
			return "redirect:view";
		}
	}
	
	/**
	 * method to call deleteShoe() 
	 * @param shoe
	 * @param result
	 * @return String
	 */
	@RequestMapping(path="/deleteproduct", method=RequestMethod.POST)
	public String deleteProduct(@ModelAttribute("shoe") Shoe shoe, BindingResult result) {	
		//if shoe deletion is successful, go to view page
		if(interf.deleteShoe(shoe))
		{
			return "redirect:view";
		}
		//else, go to view page
		else 
		{
			System.out.println("Failed to delete shoe");
			return "redirect:view";
		}
	}
	
	/**
	 * method to go to view page
	 * @return ModelAndView
	 */
	@RequestMapping(path="/view", method=RequestMethod.GET)
	public ModelAndView displayShoes() {	
		//create a list of shoes and return with view
		List<Shoe> shoes = interf.getAllShoes();
		User user = service.getCurrentUser();
		//if new guest user, return guest product result
		if(service.getCurrentUser() == null) {
			ModelAndView mv = new ModelAndView("guestProductResult");
			mv.addObject("shoes", shoes);
			return mv;
			//if user has logged out return guest page
		} else if(service.getCurrentUser().getId() <= 0) {
			return new ModelAndView("guestProductResult", "shoes", shoes);
			//if user is not an admin, return product result
		} else if(service.getCurrentUser().getAdmin() == 0) {
			ModelAndView mv = new ModelAndView("productResult");
			mv.addObject("shoes", shoes);
			mv.addObject("user", user);
			return mv;
			//if admin, return admin product result
		} else {
			ModelAndView mv = new ModelAndView("adminProductResult");
			mv.addObject("shoes", shoes);
			mv.addObject("user", user);
			return mv;
		}
	}
	
	/**
	 * setter method
	 * @param interf
	 * @return void
	 */
	@Autowired
	public void setProductBusinessService(ProductBusinessInterface interf)
	{
		this.interf=interf;
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
