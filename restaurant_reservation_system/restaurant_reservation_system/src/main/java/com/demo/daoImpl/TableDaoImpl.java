package com.demo.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.dao.TableDao;
import com.demo.entity.Customer;
import com.demo.entity.RestaurantTable;

import util.HibernateUtil;

public class TableDaoImpl implements TableDao
{
	Scanner sc=new Scanner(System.in);
	
	@Override
	public RestaurantTable createTable(RestaurantTable table) {
		try(Session session=HibernateUtil.getSession()) 
		{
			session.beginTransaction();
			session.save(table);
			session.getTransaction().commit();
			return table;
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
	public RestaurantTable getTable(String tableId) {
		try(Session session=HibernateUtil.getSession()) 
		{
			RestaurantTable table=session.get(RestaurantTable.class, tableId);
			return table;
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
	public List<RestaurantTable> getAllRestaurantTable() {
		try(Session session=HibernateUtil.getSession()) {		
			//execute HQL query to retrieve all students data
			Query<RestaurantTable> query=session.createQuery("FROM RestaurantTable");
			List<RestaurantTable> tableList=query.list();
			return tableList;	
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
	public RestaurantTable updateRestaurantTable(String tableID, RestaurantTable updatedCustomer) {
		try(Session session=HibernateUtil.getSession()) {
			RestaurantTable table=session.get(RestaurantTable.class, tableID);
			session.beginTransaction();		
			table.setTableId(tableID);
			table.setTableNo(updatedCustomer.getTableNo());
			table.setCapacity(updatedCustomer.getCapacity());
			table.setReservations(updatedCustomer.getReservations());
			table.setAvailable(updatedCustomer.isAvailable());

			session.saveOrUpdate(table);
			session.getTransaction().commit();
			return table;		
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
	public String deleteRestaurantTable(String customerId) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			RestaurantTable table=session.get(RestaurantTable.class, customerId);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(table);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(table);//data will remove from session Cache
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
