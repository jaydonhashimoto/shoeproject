/**
 * Class: ProductBusinessClass
 * Objective: This contains business logic to add product
 */
package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ShoeDataAccessInterface;
import com.gcu.model.Shoe;

public class ProductBusinessService implements ProductBusinessInterface
{	
	@Autowired
	@SuppressWarnings("unchecked")
	ShoeDataAccessInterface dao;

	/**
	 * method to start session
	 * @return void
	 */
	@Override
	public void init() {
		//print init msg
		System.out.println("init() in ProductBusinessClass");
	}
     
	/**
	 * method to end session
	 * @return void
	 */
	@Override
	public void destroy() {
		//print destroy msg
		System.out.println("init() in ProductBusinessClass");
	}
	
	/**
	 * method to get all shoes
	 * @return List<Shoe>
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Shoe> getAllShoes() {
		//return shoes from dao
		return dao.findAllShoes();
	}

	/**
	 * method to insert a shoe
	 * @param Shoe
	 * @return boolean
	 * */
	@Override
	@SuppressWarnings("unchecked")
	public boolean insertShoe(Shoe s) {
		//if shoe creation was successful, return true
		if(dao.createShoe(s))
		{
			return true;
		}
		else
			return false;
	}

	/**
	 * method to update a shoe
	 * @param Shoe
	 * @return boolean
	 * */
	@Override
	@SuppressWarnings("unchecked")
	public boolean updateShoe(Shoe s) {
		//if update shoe was successful, return true
		if(dao.updateShoe(s))
		{
			return true;
		}
		else
			return false;
	}

	/**
	 * method to delete a shoe
	 * @param Shoe
	 * @return boolean
	 * */
	@Override
	@SuppressWarnings("unchecked")
	public boolean deleteShoe(Shoe s) {
		//if shoe delete was successful, return true
		if(dao.deleteShoe(s))
		{
			return true;
		}
		return false;
	}
}
