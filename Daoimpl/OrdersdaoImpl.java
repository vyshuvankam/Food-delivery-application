package com.tap.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.connection.DBconnection;
import com.tap.dao.OrdersDao;
import com.tap.model.Orders;

public class OrdersdaoImpl implements OrdersDao
{
	
	private static final String ADD_ORDER = "INSERT INTO orders(userId,restaurantid,totalAmount,orderDate,address,paymentMethod,status) VALUES(?,?,?,?,?,?,?)";
	private static final String GET_ORDER = "SELECT * FROM orders WHERE orderId=?";
	private static final String GET_ORDERS_BY_USER = "SELECT * FROM orders";
	private static final String UPDATE_ORDER = "UPDATE orders SET status=? WHERE orderId=?";
	private static final String DELETE_ORDER="DELETE FROM orders WHERE orderId=?";



	@Override
	public int addOrder(Orders order) 
	{
		int orderId=0;
		Connection connection = DBconnection.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(ADD_ORDER , Statement.RETURN_GENERATED_KEYS)) 
		{
			ps.setInt(1, order.getUserId());
			ps.setInt(2, order.getRestaurantId());
			ps.setDouble(3, order.getTotalAmount());
			ps.setTimestamp(4, order.getOrderdate());
			ps.setString(5, order.getAddress());
			ps.setString(6, order.getPaymentMethod());
			ps.setString(7, order.getStatus());
			
			int affectedRows = ps.executeUpdate();
			
			if(affectedRows == 0)
			{
				throw new SQLException("Creating order failed , no rows affected");
			}
			
				ResultSet generatedKeys = ps.getGeneratedKeys();
				{
					if(generatedKeys.next())
					{
						orderId = generatedKeys.getInt(1);
					}
					else
					{
						throw new SQLException("Creating order failed , no ID obtained");

					}
				}
			}
		catch (SQLException e) 
		{
			throw new RuntimeException("Error adding order" , e);
		}
		return orderId;
		
	}

	@Override
	public Orders getOrder(int orderId)
	{
		Orders Orders=null;
	
		try (Connection connection = DBconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_ORDER))
		{
			statement.setInt(1, orderId);
			ResultSet res = statement.executeQuery();
			while(res.next()) 
			{

				int orderId1 = res.getInt("orderId");
				int userId1 = res.getInt("userId");
				int restaurantId = res.getInt("restaurantId");
				int totalAmount = res.getInt("totalAmount");
				Timestamp orderDate = res.getTimestamp("orderDate");
				String address = res.getString("address");
				String paymentMenthod = res.getString("paymentMethod");
				String status = res.getString("status");
				
				Orders order = new Orders(orderId1, userId1, restaurantId, totalAmount, orderDate, address, paymentMenthod, status);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return Orders;
	}

	@Override
	public List<Orders> getOrdersByUser(int userId) 
	{

		List<Orders> list = new ArrayList<>();
		
		try (Connection connection = DBconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_ORDERS_BY_USER)) 
		{
			statement.setInt(1, userId);
			ResultSet res = statement.executeQuery();
			while (res.next()) 
			{
				int orderId1 = res.getInt("orderId");
				int userId1 = res.getInt("userId");
				int restaurantId = res.getInt("restaurantId");
				int totalAmount = res.getInt("totalAmount");
				Timestamp orderDate = res.getTimestamp("orderDate");
				String address = res.getString("address");
				String paymentMenthod = res.getString("paymentMethod");
				String status = res.getString("status");
				
				Orders order = new Orders(orderId1, userId1, restaurantId, totalAmount, orderDate, address, paymentMenthod, status);
				list.add(order);
			}
		
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateOrder(Orders orders) 
	{
		Connection connection = DBconnection.getConnection();

		try (PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER)) 
		{
			statement.setString(1, orders.getStatus());
			statement.setInt(2, orders.getOrderId());
			
			
			int res=statement.executeUpdate();
			
			System.out.println(res);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
 
	}



	@Override
	public void deleteOrder(int orderId) 
	{
		Connection connection = DBconnection.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(DELETE_ORDER)) 
		{
			statement.setInt(1, orderId);
			int row=statement.executeUpdate();
			System.out.println(row);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}



