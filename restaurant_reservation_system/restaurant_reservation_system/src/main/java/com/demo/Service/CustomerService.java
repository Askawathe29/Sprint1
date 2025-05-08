package com.demo.Service;

import java.util.List;

import com.demo.entity.Admin;
import com.demo.entity.Customer;

public interface CustomerService 
{
	Customer createCustomer(Customer customer);	
	Customer getCustomer(String customerId);
	List<Customer> getAllCustomer();
	Customer updateCustomer(String customerId,Customer updatedCustomer);
	String deleteCustomer(String customerId);
	
	Customer loginCustomer(String username,String password);
}
