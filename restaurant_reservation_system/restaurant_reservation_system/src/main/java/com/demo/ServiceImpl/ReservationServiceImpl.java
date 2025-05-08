package com.demo.ServiceImpl;

import java.util.List;

import com.demo.Service.ReservationService;
import com.demo.dao.ReservationDao;
import com.demo.daoImpl.ReservationDaoImpl;
import com.demo.entity.Reservation;

public class ReservationServiceImpl implements ReservationService
{
	ReservationDao reservationDao=new ReservationDaoImpl();
	@Override
	public Reservation createReservation(Reservation reservation) 
	{
		return reservationDao.createReservation(reservation);
	}
	@Override
	public Reservation getReservation(String reservationId) 
	{
		return reservationDao.getReservation(reservationId);
	}
	@Override
	public List<Reservation> getAllReservation() {
		return reservationDao.getAllReservation();
	}
	@Override
	public Reservation updateReservation(String reservationId, Reservation updatedReservation) {
		return reservationDao.updateReservation(reservationId, updatedReservation);
	}
	@Override
	public String deleteReservation(String reservationId) {
		return reservationDao.deleteReservation(reservationId);
	}
	
	@Override
	public Reservation getReservationByRestaurantId(String restaurantId) {
		return reservationDao.getReservationByRestaurantId(restaurantId);
	}

}
