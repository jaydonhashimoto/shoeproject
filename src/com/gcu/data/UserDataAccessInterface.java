/**
 * Class: UserDataAccessInterface
 */
package com.gcu.data;

import java.util.List;

import com.gcu.model.User;

/**
 * 
 * @author Sunjil and Jaydon
 *
 * 
 */
public interface UserDataAccessInterface <T>{
	/**
	 * 
	 * @param t
	 * @return boolean
	 */
	public boolean createUser(T t);
	/**
	 * 
	 * @param t
	 * @return boolean
	 */
	public boolean findUser(T t);
	/**
	 * 
	 * @param t
	 * @return boolean
	 */
	public boolean findEmail(T t);
	/**
	 * 
	 * @param t
	 * @return boolean
	 */
	public User findUserInfo(T t);
	/**
	 * 
	 * @return List
	 */
	public List<T> findAllUsers();
}
