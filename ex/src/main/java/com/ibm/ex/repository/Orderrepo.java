package com.ibm.ex.repository;

import java.util.List;

import com.ibm.ex.model.Orders;

public interface Orderrepo {
	List<Orders> getAllOrders() throws Exception;
	Orders getOrderById(String orderId) throws Exception;
	Orders updateById(String orderId,String orderType,boolean confirmed,double orderPrice)throws Exception;
}
