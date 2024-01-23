package com.ibm.ex.service;

import java.util.List;

import com.ibm.ex.model.Customer;

public interface CustomerService {
	Customer createCustomer(Customer customer)throws Exception;
	List<Customer> getAllCustomers() throws Exception;
	Customer getCustomerByCustomerId(String customerId) throws Exception;
	Customer updateById(String customerId,String customerName)throws Exception;
}
