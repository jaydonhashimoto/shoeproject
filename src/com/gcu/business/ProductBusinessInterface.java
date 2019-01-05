/**
 * Class: ProductBusinessInterface
 * 
 */
package com.gcu.business;

import java.util.List;

import com.gcu.model.Shoe;


public interface ProductBusinessInterface {
	
	public void init();
	public void destroy();
	public List<Shoe> getAllShoes();
	public boolean insertShoe(Shoe s);
	public boolean updateShoe(Shoe s);
	public boolean deleteShoe(Shoe s);


}
