package com.demo.daoImpl;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.demo.dao.AdminDao;
import com.demo.entity.Admin;

import util.HibernateUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin createAdmin(Admin admin) {
		try(Session session=HibernateUtil.getSession()) 
		{
			session.beginTransaction();
			session.save(admin);
			session.getTransaction().commit();
			return admin;
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
	public Admin getAdmin(String adminId) {
		try(Session session=HibernateUtil.getSession()) 
		{
			Admin admin=session.get(Admin.class, adminId);
			return admin;
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
	public Admin getAdminByUsernameAndPassword(String username, String password) {
	    Admin admin = null;
	    try (Session session = HibernateUtil.getSession()) {
	        session.beginTransaction();

	        admin = (Admin) session.createQuery(
	                "FROM Admin a WHERE a.username = :username AND a.password = :password")
	                .setParameter("username", username.trim())
	                .setParameter("password", password.trim())
	                .getSingleResult();

	        if (admin != null) {
	            System.out.println("Username: " + admin.getUsername() + ", Password: " + admin.getPassword());
	        }

	        session.getTransaction().commit();
	    } catch (NoResultException e) {
	        System.out.println("No matching admin found.");
	    } catch (HibernateException e) {
	        System.out.println("Hibernate error: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	    return admin;
	}

}
