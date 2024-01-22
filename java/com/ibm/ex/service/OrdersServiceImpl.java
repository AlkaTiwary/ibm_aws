package com.ibm.ex.service;

import java.util.List;

import com.ibm.ex.model.Orders;
import com.ibm.ex.repository.Orderrepo;
import com.ibm.ex.repository.OrderrepoImpl;

public class OrdersServiceImpl implements OrdersService {
	private Orderrepo orderRepository;
			
			{
				orderRepository=new OrderrepoImpl();
			}
	@Override
			public List<Orders> getAllOrders() throws Exception {
				// TODO Auto-generated method stub
				return orderRepository.getAllOrders();
			}
}
