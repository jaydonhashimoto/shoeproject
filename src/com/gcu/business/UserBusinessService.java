/**
 * Class: UserBusinessService
 * Objective: This contains business logic to register and login user
 */
package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.gcu.data.UserDataAccessInterface;

import com.gcu.model.User;
import com.gcu.util.UserNotFoundException;

public class UserBusinessService implements UserBusinessInterface {

	@Autowired

	UserDataAccessInterface dao;
	
	//current user
	User u = new User();
	
	/**
	 * method to insert a user
	 * @param User
	 * @return boolean
	 * */
	@Override
	@SuppressWarnings("unchecked")
	public boolean insertUser(User user)
	{
		//if create user was successful, return true
		if(dao.createUser(user))
		{
			return true;
		}
		else
			return false;
	}
	
	/**
	 * method to login a user
	 * @param User
	 * @return boolean
	 * */
	@Override
	@SuppressWarnings("unchecked")
	public boolean findUser(User user) throws UserNotFoundException
	{
		//if user is found, return true
		if(dao.findUser(user))
		{
			return true;
		}
		else
			throw new UserNotFoundException();
	}
	
	/**
	 * method to check for duplicate users
	 * @param User
	 * @return boolean
	 * */
	@Override
	@SuppressWarnings("unchecked")
	public boolean isDublicate(User user) 
	{
		//if duplicate user is found, return true
		if(dao.findEmail(user))
		{
			return true;
		}
		else
			return false;
	}
	
	/**
	 * method to start session
	 * @return void
	 */
	public void init()
	{
		//print init msg
		System.out.println("init() using session UserBusinessService");
	}
	
	/**
	 * method to destroy session 
	 * @return void
	 */
	public void destroy()
	{
		//print destroy msg
		System.out.println("destroy() in UserBusinessService");
	}

	/**
	 * method to return user info
	 * @param User
	 * @return User
	 */
	@Override
	@SuppressWarnings("unchecked")
	public User getUser(User user) {
		//return user info
		User tmp = (User) dao.findUserInfo(user);
		//set u to current user
		u = tmp;
		return tmp;
	}

	/**
	 * method to return the current user info
	 * @return User
	 */
	@Override

	public User getCurrentUser() {
		//return the user set in getUser()
		return u;
	}
	
	/**
	 * method to get all users
	 * @return List<User>
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		//return list from findAllUsers()
		return dao.findAllUsers();
	}
}
