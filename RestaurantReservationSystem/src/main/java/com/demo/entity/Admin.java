package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //Marks the class as Hibernate entity (mapped to database table)
public class Admin 
{
	@Id //Marks the field as primary key
	private String adminId;
	private String username;
	private String password;
	private String email;
	
	//Default constructor
	public Admin() {
		super();
	}
	
	//Parameterized constructor
	public Admin(String adminId, String username, String password, String email) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	//Getter and Setter methods
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//To String method
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", username=" + username + ", password=" + password + ", email=" + email
				+ "]";
	}	
}
