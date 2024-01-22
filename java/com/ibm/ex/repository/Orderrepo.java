package com.ibm.ex.repository;

import java.util.List;

import com.ibm.ex.model.Orders;

public interface Orderrepo {
	List<Orders> getAllOrders() throws Exception;

}
