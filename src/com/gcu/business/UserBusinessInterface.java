/**
 * Class: UserBusinessInterface
 * 
 */
package com.gcu.business;

import java.util.List;

import com.gcu.model.User;
import com.gcu.util.UserNotFoundException;

/**
 * 
 * @author sunze
 *
 */
public interface UserBusinessInterface{
	public boolean insertUser(User user);
	public boolean findUser(User user)throws UserNotFoundException;
	public boolean isDublicate(User user);
	public void init();
	public void destroy();
	public User getUser(User user);
	public User getCurrentUser();
	public List<User> getAllUsers();
}
