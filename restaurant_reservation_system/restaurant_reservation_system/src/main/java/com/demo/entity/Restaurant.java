package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  //Marks the class as Hibernate entity (mapped to database table)
public class Restaurant
{
	@Id  //Marks the field as primary key
	private String restaurantId;
	private String restaurantName;
	private String address;
	private String menu;
	private String restaurantContactNo;
	
	//Default constructor
	public Restaurant() {
		super();
	}	
	//Parameterized constructor
	public Restaurant(String restaurantId, String restaurantName, String address, String menu,
			String restaurantContactNo) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.menu = menu;
		this.restaurantContactNo = restaurantContactNo;
	}	
	//Getter and Setter methods
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantAddress() {
		return address;
	}
	public void setRestaurantAddress(String address) {
		this.address = address;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getRestaurantContactNo() {
		return restaurantContactNo;
	}
	public void setRestaurantContactNo(String restaurantContactNo) {
		this.restaurantContactNo = restaurantContactNo;
	}
	//To String method
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantAddress=" + address + ", menu=" + menu + ", restaurantContactNo="
				+ restaurantContactNo + "]";
	}
}