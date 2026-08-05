package com.tap.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.connection.DBconnection;
import com.tap.dao.OrderItemsDao;
import com.tap.model.OrderItems;

public class OrderItemsDaoImpl implements OrderItemsDao
{

	private static final String INSERT_QUERY = "INSERT INTO order_items(orderId,itemName,quantity,totalPrice) VALUES(?,?,?,?)";
	private static final String GET_ITEMS_BY_ORDER = "SELECT * FROM order_items WHERE orderId=?";
	private static final String DELETE_ORDER_ITEM="DELETE FROM order_items WHERE orderItemId=?";
	private static final String GET_ORDER_ITEM="Select * from orderItem WHERE orderItemId=?";
	private static final String UPDATE_ORDER_ITEM="UPDATE orderItems SET orderId=?, itemName=?, quantity=?, totalPrice=? WHERE orderItemId=?";
	

	@Override
	public int addOrderItem(OrderItems item) 
	{
		int res=0;
		
		Connection connection = DBconnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) 
        {
        	statement.setInt(1, item.getOrderId());
        	statement.setString(2, item.getItemName());
        	statement.setInt(3, item.getQuantity());
        	statement.setDouble(4, item.getTotalPrice());
        	
            res=statement.executeUpdate();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return res;
	}

	@Override
	public List<OrderItems> getItemsByOrder(int orderId) 
	{
		Connection connection = DBconnection.getConnection();

		List<OrderItems> list = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(GET_ITEMS_BY_ORDER)) {
			statement.setInt(1, orderId);
			ResultSet res = statement.executeQuery();
			while (res.next()) 
			{
				OrderItems orderItems = new OrderItems();
				int orderItemId = res.getInt("orderItemId");
				int orderId1 = res.getInt("orderId");
				String itemName = res.getString("itemName");
				int quantity = res.getInt("quantity");
				double totalPrice = res.getDouble("totalPrice");

				OrderItems orderItems2 = new OrderItems(orderItemId, orderId1, itemName, quantity, totalPrice);
				list.add(orderItems2);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;		
	}

	@Override
	public void deleteOrderItem(int orderItemId)
	{
		Connection connection = DBconnection.getConnection();

		try (PreparedStatement statement = connection.prepareStatement(DELETE_ORDER_ITEM))
		{
			statement.setInt(1, orderItemId);
            int res= statement.executeUpdate();
            System.out.println(res);
        } 
		catch (SQLException e)
		{
            e.printStackTrace();
        }
	}

	@Override
	public OrderItems getOrderItem(int orderItemId) {

	    OrderItems item = null;

	    try {
	        Connection connection = DBconnection.getConnection();
	        PreparedStatement statement = connection.prepareStatement(GET_ORDER_ITEM);

	        statement.setInt(1, orderItemId);

	        ResultSet set = statement.executeQuery();

	        if (set.next()) {
	            int orderId = set.getInt("orderId");
	            int itemId = set.getInt("orderItemId");
	            String name = set.getString("itemName");
	            int quantity = set.getInt("quantity");
	            double totalPrice = set.getDouble("totalPrice");

	            item = new OrderItems(orderId, itemId, name, quantity, totalPrice);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return item;
	}
	@Override
	public void updateOrderItem(OrderItems item) {

	    try {
	        Connection connection = DBconnection.getConnection();
	        PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER_ITEM);

	        statement.setInt(1, item.getOrderId());
	        statement.setString(2, item.getItemName());
	        statement.setInt(3, item.getQuantity());
	        statement.setDouble(4, item.getTotalPrice());
	        statement.setInt(5, item.getOrderItemId());

	        int res=statement.executeUpdate();
	        System.out.println(res);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
		


}
