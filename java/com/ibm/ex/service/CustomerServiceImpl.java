package com.ibm.ex.service;

import java.util.List;

import com.ibm.ex.model.Customer;
import com.ibm.ex.repository.Customerrepo;
import com.ibm.ex.repository.CustomerrepoImpl;


public class CustomerServiceImpl implements CustomerService {
private Customerrepo customerRepository;
	
	{
		customerRepository=new CustomerrepoImpl();
	}

	@Override
	public Customer createCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return customerRepository.createCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomers() throws Exception {
		// TODO Auto-generated method stub
		return customerRepository.getAllCustomers();
	}
}
