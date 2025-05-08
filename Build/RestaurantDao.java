package com.demo.dao;

import java.util.List;
import com.demo.entity.Reservation;
import com.demo.entity.Restaurant;
public interface RestaurantDao
{
	Restaurant createRestaurant(Restaurant restaurant);
	Restaurant getRestaurant(String restaurantId);
	List<Restaurant> getAllRestaurant();
	Reservation tableReservation(Reservation reservation);
	List<Reservation> getReservationDetailsByRestauratId(String restaurantId);
	Restaurant updateRestaurant(String restaurantID,Restaurant updatedRestaurant);
	String deleteRestaurant(String restaurantID);
}
