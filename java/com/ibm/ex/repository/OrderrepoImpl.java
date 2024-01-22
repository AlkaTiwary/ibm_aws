package com.ibm.ex.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ibm.ex.factory.MysessionFactory;
import com.ibm.ex.model.Orders;

public class OrderrepoImpl implements Orderrepo {
private SessionFactory sessionFactory;
	
	{
		sessionFactory=MysessionFactory.getSessionFactory();
	}
	@Override
	public List<Orders> getAllOrders() throws Exception {
		Session session=sessionFactory.openSession();
		TypedQuery<Orders> query=session.createQuery("FROM Orders O",Orders.class);
		return query.getResultList();
	}
}
