package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //Marks the class as Hibernate entity (mapped to database table)
@Table(name ="tables")
public class RestaurantTable 
{
	@Id  //Marks the field as primary key
	private String tableId;
	private int tableNo;
	private int capacity;
	private int reservations;
	private boolean isAvailable;
	
	//Default constructor
	public RestaurantTable() {
		super();
	}
	//Parameterized constructor
	public RestaurantTable(String tableId, int tableNo, int capacity, int reservations, boolean isAvailable) {
		super();
		this.tableId = tableId;
		this.tableNo = tableNo;
		this.capacity = capacity;
		this.reservations = reservations;
		this.isAvailable = isAvailable;
	}
	//Getter and Setter methods
	public String getTableId() {
		return tableId;
	}
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	public int getTableNo() {
		return tableNo;
	}
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getReservations() {
		return reservations;
	}
	public void setReservations(int reservations) {
		this.reservations = reservations;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	//To String method
	@Override
	public String toString() {
		return "Table [tableId=" + tableId + ", tableNo=" + tableNo + ", capacity=" + capacity + ", reservations="
				+ reservations + ", isAvailable=" + isAvailable + "]";
	}	
}