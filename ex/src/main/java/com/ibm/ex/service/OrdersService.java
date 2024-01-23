package com.ibm.ex.service;

import java.util.List;

import com.ibm.ex.model.Orders;

public interface OrdersService {
	List<Orders> getAllOrders() throws Exception;
	Orders getOrderById(String orderId) throws Exception;
	Orders updateById(String orderId,String orderType,boolean confirmed,double orderPrice)throws Exception;
}
