package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  //Marks the class as Hibernate entity (mapped to database table)
public class Reservation
{
	@Id  //Marks the field as primary key
	private String reservationId ;
	private String restaurantId;
	private String customerId;
	private String tableId;
	private String reservationDate;
	private String reservationTime;
	
	//Default constructor
	public Reservation() {
		super();
	}	
	//Parameterized constructor
	public Reservation(String reservation_id, String restaurantId, String customerId, String tableId,
			String reservationDate, String reservationTime) {
		super();
		this.reservationId = reservation_id;
		this.restaurantId = restaurantId;
		this.customerId = customerId;
		this.tableId = tableId;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
	}	
	//Getter and Setter methods
	public String getReservation_id() {
		return reservationId;
	}
	public void setReservation_id(String reservation_id) {
		this.reservationId = reservation_id;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getTableId() {
		return tableId;
	}
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	public String getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}
	//To String method
	@Override
	public String toString() {
		return "Reservation [reservation_id=" + reservationId + ", restaurantId=" + restaurantId + ", customerId="
				+ customerId + ", tableId=" + tableId + ", reservationDate=" + reservationDate + ", reservationTime="
				+ reservationTime + "]";
	}
}