/**
 * Class: ProductBusinessClass
 * Objective: This contains business logic to add product
 */
package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ShoeDataAccessInterface;
import com.gcu.model.Shoe;

public class ProductBusinessClass implements ProductBusinessInterface
{	
	@SuppressWarnings("rawtypes")
	@Autowired
	ShoeDataAccessInterface dao;

	/**
	 * method to start session
	 */
	@Override
	public void init() {
		System.out.println("init() in ProductBusinessClass");
	}
     
	/**
	 * method to end session
	 */
	@Override
	public void destroy() {
		System.out.println("init() in ProductBusinessClass");
	}
	
	/**
	 * method to get all shoes
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Shoe> getAllShoes() {
		return dao.findAllShoes();
	}

	/**
	 * method to insert a shoe
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public boolean insertShoe(Shoe s) {
		if(dao.createShoe(s))
		{
			return true;
		}
		else
			return false;
	}

	/**
	 * method to update a shoe
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public boolean updateShoe(Shoe s) {
		if(dao.updateShoe(s))
		{
			return true;
		}
		else
			return false;
	}

	/**
	 * method to delete a shoe
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteShoe(Shoe s) {
		if(dao.deleteShoe(s))
		{
			return true;
		}
		return false;
	}
	 
	
}
