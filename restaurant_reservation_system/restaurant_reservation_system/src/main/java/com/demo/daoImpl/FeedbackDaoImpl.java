package com.demo.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.dao.FeedbackDao;
import com.demo.entity.Feedback;
import util.HibernateUtil;

public class FeedbackDaoImpl implements FeedbackDao {

	Scanner sc=new Scanner(System.in);
	@Override
	public Feedback createFeedback(Feedback feedback) {
		try(Session session=HibernateUtil.getSession()) 
		{
			session.beginTransaction();
			session.save(feedback);
			session.getTransaction().commit();
			return feedback;
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
	public Feedback getFeedback(String feedbackId) {
		try(Session session=HibernateUtil.getSession()) 
		{
			Feedback feedback=session.get(Feedback.class, feedbackId);
			return feedback;
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
	public List<Feedback> getAllFeedback() {
		try(Session session=HibernateUtil.getSession()) {		
			//execute HQL query to retrieve all students data
			Query<Feedback> query=session.createQuery("FROM Feedback");
			List<Feedback> feedbackList=query.list();
			return feedbackList;	
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
	public Feedback updateFeedback(String feedbackID, Feedback updatedFeedback) {
		try(Session session=HibernateUtil.getSession()) {
			Feedback feedback=session.get(Feedback.class, feedbackID);
			session.beginTransaction();		
			feedback.setCustomerId(feedbackID);
			feedback.setFeedbackId(updatedFeedback.getFeedbackId());
			feedback.setRestaurantId(updatedFeedback.getRestaurantId());
			feedback.setCustomerId(updatedFeedback.getCustomerId());
			feedback.setfeedbackText(updatedFeedback.getfeedbackText());

			session.saveOrUpdate(feedback);
			session.getTransaction().commit();
			return feedback;		
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
	public String deleteFeedback(String feedbackId) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Feedback feedback=session.get(Feedback.class, feedbackId);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(feedback);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(feedback);//data will remove from session Cache
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
