package com.demo.Service;

import java.util.List;

import com.demo.entity.Reservation;

public interface ReservationService
{
	Reservation createReservation(Reservation reservation);	
	Reservation getReservation(String reservationId);
	List<Reservation> getAllReservation();
	Reservation updateReservation(String reservationId,Reservation updatedReservation);
	String deleteReservation(String reservationId);
	
	Reservation getReservationByRestaurantId(String restaurantId);

}
