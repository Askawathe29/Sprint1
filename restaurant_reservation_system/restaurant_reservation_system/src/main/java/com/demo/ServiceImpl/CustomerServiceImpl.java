package com.demo.ServiceImpl;

import java.util.List;

import com.demo.Service.CustomerService;
import com.demo.dao.CustomerDao;
import com.demo.daoImpl.CustomerDaoImpl;
import com.demo.entity.Admin;
import com.demo.entity.Customer;

public class CustomerServiceImpl  implements CustomerService
{
	CustomerDao customerDao=new CustomerDaoImpl();
	@Override
	public Customer createCustomer(Customer customer) 
	{
		return customerDao.createCustomer(customer);
	}
	@Override
	public Customer getCustomer(String customerId) 
	{
		return customerDao.getCustomer(customerId);
	}
	@Override
	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}
	@Override
	public Customer updateCustomer(String customerId, Customer updatedCustomer) {
		return customerDao.updateCustomer(customerId, updatedCustomer);
	}
	@Override
	public String deleteCustomer(String customerId) {
		return customerDao.deleteCustomer(customerId);
	}
	
	@Override
	public Customer loginCustomer(String username,String password) {
		return customerDao.getCustomerByUsernameAndPassword( username, password);
	}
}
