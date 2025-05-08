package com.demo.daoImpl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.dao.ReservationDao;
import com.demo.entity.Reservation;

import util.HibernateUtil;

public class ReservationDaoImpl implements ReservationDao
{
	Scanner sc=new Scanner(System.in);

	@Override
	public Reservation createReservation(Reservation reservation)
	{
		try(Session session=HibernateUtil.getSession()) 
		{
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
	public Reservation getReservation(String reservationId) 
	{
		try(Session session=HibernateUtil.getSession()) 
		{
			Reservation reservation=session.get(Reservation.class, reservationId);
			return reservation;
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
	public List<Reservation> getAllReservation() {
		try(Session session=HibernateUtil.getSession()) {		
			//execute HQL query to retrieve all students data
			Query<Reservation> query=session.createQuery("FROM Reservation");
			List<Reservation> reservationList=query.list();
			return reservationList;	
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
	public Reservation updateReservation(String reservationID, Reservation updatedReservation) {
		try(Session session=HibernateUtil.getSession()) {
			Reservation reservation=session.get(Reservation.class, reservationID);
			session.beginTransaction();		
			reservation.setReservationDate(updatedReservation.getReservationDate());
			reservation.setReservationTime(updatedReservation.getReservationTime());
			
			session.saveOrUpdate(reservation);
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
	public String deleteReservation(String reservationId) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Reservation reservation=session.get(Reservation.class, reservationId);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(reservation);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(reservation);//data will remove from session Cache
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
	
	@Override
	public Reservation getReservationByRestaurantId(String restaurantId) {
		Reservation reservation = null;
	    try (Session session = HibernateUtil.getSession()) {
	        session.beginTransaction();

	        reservation = (Reservation) session.createQuery(
	                "FROM Reservation r WHERE r.reservationId = :reservationId")
	                .setParameter("restaurantId", restaurantId.trim())
	                .getSingleResult();

	        if (reservation != null) {
	            System.out.println("RsetaurantId: " + reservation.getRestaurantId());
	        }

	        session.getTransaction().commit();
	    } catch (NoResultException e) {
	        System.out.println("No matching customer found.");
	    } catch (HibernateException e) {
	        System.out.println("Hibernate error: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	    return reservation;
	}


}
