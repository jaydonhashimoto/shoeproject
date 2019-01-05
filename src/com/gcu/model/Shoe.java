package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Shoe model
 * @author jaydon
 *
 */
public class Shoe {
	//attributes
	private int id;
	
	@NotNull(message="Brand cannot be null")
	@Size(min=2, max=20, message="Brand must be between 2 and 20 characters")
	private String brand;
	
	@NotNull(message="Color cannot be null")
	@Size(min=2, max=30, message="Color must be between 2 and 20 characters")
	private String color;
	
	@NotNull(message="Color cannot be null")
	private int size;
	
	@NotNull(message="Color cannot be null")
	private float price;
	
	/**
	 * constructor
	 */
	public Shoe()
	{
		brand = "";
		color = "";
		size = 0;
		price = 0;
		
	}
	
	/**
	 * constructor with parameters
	 * @param id
	 * @param brand
	 * @param color
	 * @param size
	 * @param price
	 */
	public Shoe(int id, String brand, String color, int size, float price)
	{
		this.id = id;
		this.brand=brand;
		this.color= color;
		this.size= size;
		this.price=price;
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
	 * get brand method
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * set brand method
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * get color method
	 * @return color
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * set color method
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * get size method
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * set size method
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * get price method
	 * @return price
	 */
	public float getPrice() {
		return price;
	}
	
	/**
	 * set price method
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}
}
