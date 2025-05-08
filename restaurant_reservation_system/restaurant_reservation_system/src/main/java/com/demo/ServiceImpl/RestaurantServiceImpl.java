package com.demo.ServiceImpl;

import java.util.List;

import com.demo.Service.RestaurantService;
import com.demo.entity.Reservation;
import com.demo.entity.Restaurant;
import com.demo.dao.RestaurantDao;
import com.demo.daoImpl.RestaurantDaoImpl;

public class RestaurantServiceImpl implements RestaurantService{
	RestaurantDao restaurantDao=new RestaurantDaoImpl();
	
	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		return restaurantDao.createRestaurant(restaurant);
	}
	@Override
	public Restaurant getRestaurant(String restaurantId) {
		return restaurantDao.getRestaurant(restaurantId);
	}
	@Override
	public List<Restaurant> getAllRestaurant() {
		return restaurantDao.getAllRestaurant();
	}
	@Override
	public Reservation tableReservation(Reservation reservation) {
		return restaurantDao.tableReservation(reservation);
	}
	@Override
	public List<Reservation> getReservationDetailsByRestaurantId(String restaurantId) {
		return  restaurantDao.getReservationDetailsByRestauratId(restaurantId);
	}
	@Override
	public Restaurant updateRestaurant(String restaurantId, Restaurant updatedRestaurant) {
		return restaurantDao.updateRestaurant(restaurantId, updatedRestaurant);
	}
	@Override
	public String deleteRestaurant(String restaurantId) {
		return restaurantDao.deleteRestaurant(restaurantId);
	}
}
