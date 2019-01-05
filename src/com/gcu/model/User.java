/*
 * Class: User
 * Function: Model
 * Detail: This is the model class which hold the attribute of user. 
 *  Date: 9/23/2018
 */
package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	//attributes
	private int id;
	
	@NotNull(message="Email cannot be null")
	@Size(min=2, max=20, message="Email must be between 2 and 20 characters")
	private String email;
	
	@NotNull(message="First name cannot be null")
	@Size(min=2, max=20, message="First name must be between 2 and 20 characters")
	private String firstName;
	
	@NotNull(message="Last name cannot be null")
	@Size(min=2, max=20, message="Last name must be between 2 and 20 characters")
	private String lastName;
	
	@NotNull(message="Password cannot be null")
	@Size(min=2, max=20, message="Password must be between 5 and 20 characters")
	private String password;
	
	private int admin;

	/**
	 * default constructor
	 */
	public User() {
		email = "";
		firstName = "";
		lastName = "";
		password = "";
		admin = 0;
	}
	
	/**
	 * constructor with parameters
	 * @param id
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param a
	 */
	public User(int id, String email, String firstName, String lastName, String password, int a) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.admin = a;
	}
	
	/**
	 * get id method
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * set id method
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * get email method
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * set email method
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * get first name method
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * set first name method
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * get last name method
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * set last name method
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * get password method
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set password method
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * get admin method
	 * @return admin
	 */
	public int getAdmin() {
		return admin;
	}

	/**
	 * set admin method
	 * @param admin
	 */
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	
}
