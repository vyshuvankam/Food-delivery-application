package com.tap.dao;

import java.util.List;

import com.tap.model.OrderItems;


public interface OrderItemsDao {


	int addOrderItem(OrderItems item);

	OrderItems getOrderItem(int orderItemId);
	
    List<OrderItems> getItemsByOrder(int orderId);
    
    void updateOrderItem(OrderItems items);

    void deleteOrderItem(int orderItemId);
}
