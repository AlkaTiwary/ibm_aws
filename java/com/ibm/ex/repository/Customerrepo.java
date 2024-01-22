package com.ibm.ex.repository;

import java.util.List;

import com.ibm.ex.model.Customer;

public interface Customerrepo {
	Customer createCustomer(Customer customer) throws Exception;
	List<Customer> getAllCustomers() throws Exception;
}
