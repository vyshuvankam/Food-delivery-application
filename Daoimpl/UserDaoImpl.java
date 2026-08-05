package com.tap.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.connection.DBconnection;
import com.tap.dao.UserDao;
import com.tap.model.User;

public class UserDaoImpl implements UserDao 
{
	private static final String INSERT_QUERY = "Insert into user (userId,userName,password,email,address,phoneNumber,role,lastLoginDate,createdDate) values(?,?,?,?,?,?,?,?,?)";
	private static final String GET_USER_BY_ID = "Select * from user where userId = ? ";
	private static final String UPDATE_USER ="UPDATE `user` SET userName=?, password=?, email=?, address=?, phoneNumber=? WHERE userId=?";
	private static final String DELETE_USER="Delete from user where userId= ? ";
	private static final String LIST_USER="Select * from user";

	@Override
	public int addUser(User user) 
	{
		int res=0;
		
		
		try (Connection connection = DBconnection.getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);)
		{
			statement.setInt(1,user.getUserId());
			statement.setString(2, user.getUserName());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getAddress());
			statement.setString(6, user.getPhoneNumber());
			statement.setString(7, user.getRole());
			statement.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			statement.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			
			res = statement.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public User getUser(int userId) 
	{
		User user=null;
		
		try(Connection connection = DBconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_USER_BY_ID);)
		{
		
			statement.setInt(1, userId);
			ResultSet res = statement.executeQuery();
			
			while(res.next())
			{
				int userid= res.getInt("userId");
				String userName = res.getString("userName");
				String password = res.getString("password");
				String email = res.getString("email");
				String address = res.getString("address");
				String phoneNumber = res.getString("phoneNumber");
				String role = res.getString("role");
				Timestamp lastLoginDate = res.getTimestamp("lastLoginDate");
				Timestamp createdDate = res.getTimestamp("createdDate");
				
				user = new User(userid, userName, password, email, address, phoneNumber, role, lastLoginDate, createdDate);
				
			}
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	
		return user;
	}
	
	@Override
	public void updateUser(User user) 
	{		
		try(Connection connection = DBconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USER);)
		{
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getPhoneNumber());
			statement.setInt(6, user.getUserId());
			
			
			int res = statement.executeUpdate();	
			System.out.println(res);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteUser(int userId) 
	{
		
        try (Connection connection = DBconnection.getConnection(); 
        		PreparedStatement statement = connection.prepareStatement(DELETE_USER)) 
        {
            statement.setInt(1, userId);
            int rows = statement.executeUpdate();
            System.out.println(rows);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}
	
	@Override
	public List<User> getAllUsers()
	{
		List<User> listOfUsers = new ArrayList<User>();

		try(Connection connection = DBconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(LIST_USER)) 
		{

			ResultSet res = statement.executeQuery();
			while(res.next())
			{
				int userid= res.getInt("userId");
				String userName = res.getString("userName");
				String password = res.getString("password");
				String email = res.getString("email");
				String address = res.getString("address");
				String phoneNumber = res.getString("phoneNumber");
				String role = res.getString("role");
				Timestamp lastLoginDate = res.getTimestamp("lastLoginDate");
				Timestamp createdDate = res.getTimestamp("createdDate");
				
				User user = new User(userid, userName, password, email, address, phoneNumber, role, lastLoginDate, createdDate);
				
				listOfUsers.add(user);	
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return listOfUsers;
	}
}
