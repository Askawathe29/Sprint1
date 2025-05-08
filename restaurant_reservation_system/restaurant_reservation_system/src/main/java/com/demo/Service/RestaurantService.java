package com.demo.Service;

import java.util.List;

import com.demo.entity.Reservation;
import com.demo.entity.Restaurant;

public interface RestaurantService 
{
	Restaurant createRestaurant(Restaurant restaurant);	
	List<Restaurant> getAllRestaurant();
	Reservation tableReservation(Reservation reservation);
	Restaurant getRestaurant(String restaurantId);
	List<Reservation> getReservationDetailsByRestaurantId(String restaurantId);
	Restaurant updateRestaurant(String restaurantId,Restaurant updatedRestaurant);
	String deleteRestaurant(String restaurantId);
}
