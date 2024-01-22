package com.ibm.ex.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.ex.model.Customer;
import com.ibm.ex.model.Orders;

public class MysessionFactory {
	private static SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure().addAnnotatedClass(Orders.class).addAnnotatedClass(Customer.class).buildSessionFactory();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
