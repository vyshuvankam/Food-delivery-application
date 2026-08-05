package com.tap.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection
{	
	
	private static final String URL = "jdbc:mysql://localhost:3306/fooddeliveryapplication";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Vyshu@5143";
	private static Connection connection;

	public static Connection getConnection()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return connection;
	}
	
	
}
