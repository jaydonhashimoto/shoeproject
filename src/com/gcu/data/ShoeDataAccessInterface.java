/**
 * Class: ShoeDataAccessInterface
 * Role: Shoe DAO interface class
 */
package com.gcu.data;

import java.util.List;
import com.gcu.model.Shoe;

/**
 * 
 * @author Sunjil and Jaydon
 *
 * @param <T>
 */
public interface ShoeDataAccessInterface <T> {
	/**
	 * 
	 * @return List
	 */
	public List<T> findAllShoes();
	/**
	 * 
	 * @param t
	 * @return boolean
	 */
	public boolean createShoe(T t);
	/**
	 * 
	 * @param t
	 * @return boolean
	 */
	public boolean updateShoe(T t);
	/**
	 * 
	 * @param t
	 * @return boolean
	 */
	public boolean deleteShoe(T t);
}
