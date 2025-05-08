package com.demo.dao;

import java.util.List;
import com.demo.entity.Customer;

public interface CustomerDao {
	Customer createCustomer(Customer customer);
	Customer getCustomer(String customerId);
	List<Customer> getAllCustomer();
	Customer updateCustomer(String customerId,Customer updatedCustomer);
	String deleteCustomer(String customerId);
	
	Customer getCustomerByUsernameAndPassword(String username,String password);
}
