package com.tap.dao;

import java.util.List;

import com.tap.model.Orders;

public interface OrdersDao {

	
	
	int addOrder(Orders order);

    Orders getOrder(int orderId);

    List<Orders> getOrdersByUser(int userId);

    void updateOrder(Orders orders);

    void deleteOrder(int orderId);
}

