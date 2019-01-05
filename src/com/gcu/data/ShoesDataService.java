/**
 * Class: ShoesDataService
 * Role: DAO service class for shoes
 */
package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.model.Shoe;
import com.gcu.util.DatabaseException;

@SuppressWarnings("unused")
public class ShoesDataService implements ShoeDataAccessInterface<Shoe> {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public ShoesDataService() {}
	
	/**
	 * setter method
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * method to SELECT all shoes
	 * @return List<Shoe>
	 * */
	@Override
	public List<Shoe> findAllShoes() {
		//select sql method
		String sql = "SELECT * FROM shoeproject.SHOES";
		//create a list of shoes
		List<Shoe> shoes = new ArrayList<Shoe>();
		try {
			//use sqlrowset to query sql stmt
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			//add returned shoes to shoe list
			while(srs.next()) {
				shoes.add(new Shoe(srs.getInt("ID"),
									srs.getString("BRAND"),
									srs.getString("COLOR"),
									srs.getInt("SIZE"),
									srs.getFloat("PRICE")));
			}
		} 
		
		//catching database exception
		catch (DataAccessException e)
		{
			
			throw new DatabaseException(e);
		}

		//return shoe list
		return shoes;
	}

	/**
	 * method to INSERT shoe
	 * @param s
	 * @return boolean
	 * */
	@Override
	public boolean createShoe(Shoe s) {
		//insert shoe sql stmt
		String sql = "INSERT INTO shoeproject.SHOES(BRAND, COLOR, SIZE, PRICE) VALUES(?,?,?,?)";
		try {
			//execute sql 
			int rows = jdbcTemplateObject.update(sql, s.getBrand(), s.getColor(), s.getSize(), s.getPrice());
			//if rows returned == 1 return true, else return false
			return rows == 1 ? true : false;
		}
		//catching database exception
		catch (DataAccessException e)
		{
			
			throw new DatabaseException(e);
		}

		
	}

	/**
	 * method to UPDATE shoe
	 * @param s
	 * @return boolean
	 * */
	@Override
	public boolean updateShoe(Shoe s) {
		//Update shoe sql stmt
		String sql = "UPDATE shoeproject.SHOES SET BRAND=?, COLOR=?, SIZE=?, PRICE=? WHERE ID=?";
		try {
			//execute sql
			int rows = jdbcTemplateObject.update(sql, s.getBrand(), s.getColor(), s.getSize(), s.getPrice(), s.getId());
			//if rows returned == 1 return true, else return false
			return rows == 1 ? true : false;
		}
		//catching database exception
		catch (DataAccessException e)
		{
			
			throw new DatabaseException(e);
		}

	}

	/**
	 * method to DELETE shoe
	 * @param s
	 * @return boolean
	 * */
	@Override
	public boolean deleteShoe(Shoe s) {
		//delete shoe sql stmt
		String sql = "DELETE FROM shoeproject.SHOES WHERE ID=?";
		try {
			//execute sql
			int rows = jdbcTemplateObject.update(sql, s.getId());
			//if rows returned == 1 return true, else return false
			return rows == 1 ? true : false;
		}
		//catching database exception
		catch (DataAccessException e)
		{
			throw new DatabaseException(e);
		}

	}
}
