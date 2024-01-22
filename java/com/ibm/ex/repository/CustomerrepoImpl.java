package com.ibm.ex.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ibm.ex.model.Customer;
import com.ibm.ex.factory.MysessionFactory;

public class CustomerrepoImpl implements Customerrepo {
private SessionFactory sessionFactory;
	
	{
		sessionFactory=MysessionFactory.getSessionFactory();
	}

	@Override
	public Customer createCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.persist(customer);
		session.getTransaction().commit();
		return customer;
	}
	@Override
	public List<Customer> getAllCustomers() throws Exception {
		Session session=sessionFactory.openSession();
		TypedQuery<Customer> query=session.createQuery("FROM Customer C",Customer.class);
		return query.getResultList();
	}
}
