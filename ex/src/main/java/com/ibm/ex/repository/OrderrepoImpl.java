package com.ibm.ex.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ibm.ex.factory.MysessionFactory;
import com.ibm.ex.model.Customer;
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
	@Override
	public Orders getOrderById(String orderId) throws Exception {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Orders order=session.find(Orders.class, orderId);
		return order;
	}
	@Override
	public Orders updateById(String orderId,String orderType,boolean confirmed,double orderPrice)throws Exception{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Orders order=session.get(Orders.class, orderId);
		order.setOrderType(orderType);
		order.setOrderPrice(orderPrice);
		order.setConfirmed(confirmed);

		Orders updated=(Orders) session.merge(order);
		transaction.commit();
		return updated;
		}
}
