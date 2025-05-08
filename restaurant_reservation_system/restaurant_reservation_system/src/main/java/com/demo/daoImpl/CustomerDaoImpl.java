package com.demo.daoImpl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.dao.CustomerDao;
import com.demo.entity.Customer;
import util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao 
{
	Scanner sc=new Scanner(System.in);

	@Override
	public Customer createCustomer(Customer customer)
	{
		try(Session session=HibernateUtil.getSession()) 
		{
			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();
			return customer;
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
	public Customer getCustomer(String customerId) 
	{
		try(Session session=HibernateUtil.getSession()) 
		{
			Customer customer=session.get(Customer.class, customerId);
			return customer;
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
	public List<Customer> getAllCustomer() {
		try(Session session=HibernateUtil.getSession()) {		
			//execute HQL query to retrieve all students data
			Query<Customer> query=session.createQuery("FROM Customer");
			List<Customer> customerList=query.list();
			return customerList;	
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
	public Customer updateCustomer(String customerID, Customer updatedCustomer) {
		try(Session session=HibernateUtil.getSession()) {
			Customer customer=session.get(Customer.class, customerID);
			session.beginTransaction();		
			customer.setCustomerId(customerID);
			customer.setCustomerName(updatedCustomer.getCustomerName());
			customer.setEmail(updatedCustomer.getEmail());
			customer.setCustomerContactNo(updatedCustomer.getCustomerContactNo());
			customer.setTotalReservations(updatedCustomer.getTotalReservations());

			session.saveOrUpdate(customer);
			session.getTransaction().commit();
			return customer;		
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
	public String deleteCustomer(String customerId) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Customer customer=session.get(Customer.class, customerId);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(customer);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(customer);//data will remove from session Cache
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
	public Customer getCustomerByUsernameAndPassword(String username, String password) {
		Customer customer = null;
	    try (Session session = HibernateUtil.getSession()) {
	        session.beginTransaction();

	        customer = (Customer) session.createQuery(
	                "FROM Customer c WHERE c.username = :username AND c.password = :password")
	                .setParameter("username", username.trim())
	                .setParameter("password", password.trim())
	                .getSingleResult();

	        if (customer != null) {
	            System.out.println("Username: " + customer.getUsername() + ", Password: " + customer.getPassword());
	        }

	        session.getTransaction().commit();
	    } catch (NoResultException e) {
	        System.out.println("No matching customer found.");
	    } catch (HibernateException e) {
	        System.out.println("Hibernate error: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	    return customer;
	}


}
