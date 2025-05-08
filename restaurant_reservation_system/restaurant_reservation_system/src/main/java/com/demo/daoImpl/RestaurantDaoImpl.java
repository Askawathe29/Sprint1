package com.demo.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.dao.RestaurantDao;
import com.demo.entity.Reservation;
import com.demo.entity.Restaurant;
import exception.ResourceNotFoundException;
import util.HibernateUtil;

public class RestaurantDaoImpl implements RestaurantDao
{
	Scanner sc=new Scanner(System.in);
	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		try(Session session=HibernateUtil.getSession()) 
		{
			session.beginTransaction();
			session.save(restaurant);
			session.getTransaction().commit();
			return restaurant;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Restaurant getRestaurant(String restaurantId) {
		try(Session session=HibernateUtil.getSession()) 
		{
			Restaurant restaurant=session.get(Restaurant.class, restaurantId);
			return restaurant;
		}
		catch (HibernateException e) 
		{
			System.out.println(e);
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		try(Session session=HibernateUtil.getSession()) {		
			//execute HQL query to retrieve all students data
			Query<Restaurant> query=session.createQuery("FROM Restaurant");
			List<Restaurant> restaurantList=query.list();
			return restaurantList;	
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Reservation tableReservation(Reservation reservation) {
		try(Session session=HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(reservation);
			session.getTransaction().commit();
			return reservation;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Reservation> getReservationDetailsByRestauratId(String restaurantId) {
		try(Session session=HibernateUtil.getSession()) {
			Restaurant restaurant=session.get(Restaurant.class, restaurantId);
			if(restaurant!=null)
			{
				List<Reservation> reserve=new ArrayList<>();
				//execute HQL query to retrieve all Enrollment data
				Query<Reservation> query=session.createQuery("FROM Reservation");
				List<Reservation> reservationList=query.list();
				for(Reservation r:reservationList)
				{
					if(r.getRestaurantId().equals(restaurantId))
						reserve.add(r);
				}
				return reserve;
			}
			else
			{
				throw new ResourceNotFoundException("Table id is not found");
			}	
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Restaurant updateRestaurant(String restaurantID, Restaurant updatedRestaurant) {
		try(Session session=HibernateUtil.getSession()) {
			Restaurant restaurant=session.get(Restaurant.class, restaurantID);
			session.beginTransaction();		
			restaurant.setRestaurantId(restaurantID);
			restaurant.setRestaurantName(updatedRestaurant.getRestaurantName());
			restaurant.setRestaurantAddress(updatedRestaurant.getRestaurantAddress());
			restaurant.setMenu(updatedRestaurant.getMenu());
			restaurant.setRestaurantContactNo(updatedRestaurant.getRestaurantContactNo());

			session.saveOrUpdate(restaurant);
			session.getTransaction().commit();
			return restaurant;		
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public String deleteRestaurant(String restaurantId) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Restaurant restaurant=session.get(Restaurant.class, restaurantId);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(restaurant);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(restaurant);//data will remove from session Cache
					message="Object is deleted";				
				}
				else
				{
					message="User wants to retain this object!!";
				}		
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return message;
	}
}
