/**
 * Class: DAO (Data Access Object)
 * Objective: This class contain methods that is used to query database
 */
package com.gcu.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.model.Shoe;
import com.gcu.model.User;
import com.gcu.util.DatabaseException;

@SuppressWarnings("unused")
public class UserDataService implements UserDataAccessInterface<User> {

	/**
	 * variables
	 */
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Default constructor
	 */
	public UserDataService(){}
	
	/**
	 * setter method
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Method used to create user
	 * @param user
	 * @return boolean
	 */
	@Override
	public boolean createUser(User user) {
		//insert user sql stmt
		String sql = "INSERT INTO shoeproject.USERS(EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, IS_ADMIN) VALUES(?,?,?,?,?)";
		try {
			//execute sql
			int rows = jdbcTemplateObject.update(sql, user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), 0);
			//if rows returned == 1 return true, else return false
			return rows == 1 ? true : false;
		}
		//Catching database exception and throwing custom exception
		catch (DataAccessException e)
		{
			
			throw new DatabaseException(e);
		}

		
	}
	
	/**
	 * Method used to get user's username and password from database
	 * @param user
	 * @return boolean
	 */
	@Override
	public boolean findUser(User user)
	{
		int count=0;
		//sql stmt to find user using email and password
		//LOWER() - sets text to lower case
		String sql= "SELECT * FROM shoeproject.USERS "
				+ "WHERE LOWER(EMAIL) = LOWER(?) AND PASSWORD = ?";
		try {
			//execute sql
			SqlRowSet rows= jdbcTemplateObject.queryForRowSet(sql, user.getEmail(), user.getPassword());
			while(rows.next())
			{
				//count rows returned
				++count;
			}
			
			//if no rows returned, return false
			if(count==0)
			{
				return false;
			}
			//if 1 row found, return true
			else if(count==1)
			{
				return true;
			}
		}
		//Catching database exception and throwing custom exception
		catch (DataAccessException e)
		{
			
			throw new DatabaseException(e);
		}
		return false;
	}

	/**
	 * method to find user using email
	 * @param u
	 * @return boolean
	 */
	@Override
	public boolean findEmail(User u) {
		int count=0;
		//select by email sql stmt
		String sql= "SELECT * FROM shoeproject.USERS WHERE LOWER(EMAIL)= LOWER(?)";
		try {
			//execute sql
			SqlRowSet rows= jdbcTemplateObject.queryForRowSet(sql, u.getEmail());
			while (rows.next())
			{
				//count rows returned
				++count;
			}
			
			//if no rows returned, return false
			if(count==0)
			{
				return false;
			}
			//else return true
			else
			{
				return true;
			}
		}
		//Catching database exception and throwing custom exception
		catch (DataAccessException e)
		{
			
			throw new DatabaseException(e);
		}
		
	}

	/**
	 *method to retrieve all user info 
	 *@param user
	 *@return User
	 */
	@Override
	public User findUserInfo(User user) {
		//sql string
		String sql= "SELECT * FROM shoeproject.USERS WHERE EMAIL= ? AND PASSWORD= ?";
		try {
			//query sql statement
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, user.getEmail(), user.getPassword());
			//create tmp user
			User newUser = new User();
			//set attributes
			while(srs.next()) {
				newUser.setId(srs.getInt("ID"));
				newUser.setEmail(srs.getString("EMAIL"));
				newUser.setFirstName(srs.getString("FIRST_NAME"));
				newUser.setLastName(srs.getString("LAST_NAME"));
				newUser.setPassword(srs.getString("PASSWORD"));
				newUser.setAdmin(srs.getInt("IS_ADMIN"));
			}
			//return user
			return newUser;
		}
		
		//Catching database exception and throwing custom exception
		catch (DataAccessException e)
		{
			
			throw new DatabaseException(e);
		}
	}

	/**
	 * method to select all users
	 * @return List<User>
	 */
	@Override
	public List<User> findAllUsers() {
		//sql string
		String sql= "SELECT * FROM shoeproject.USERS";
		try {
			//query sql statement
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			List<User> users = new ArrayList<User>();
			//set attributes
			while(srs.next()) {
				users.add(new User(srs.getInt("ID"), 
						srs.getString("EMAIL"), 
						srs.getString("FIRST_NAME"), 
						srs.getString("LAST_NAME"), 
						srs.getString("PASSWORD"), 
						srs.getInt("IS_ADMIN")));
			}
			//return user
			return users;
		}
		//Catching database exception and throwing custom exception
		catch (DataAccessException e)
		{
			
			throw new DatabaseException(e);
		}		
	}
}
