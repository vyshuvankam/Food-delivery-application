package com.tap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tap.connection.DBconnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet
{

	private static final String SQL = "INSERT INTO user(userId, userName, email, password, phoneNumber) VALUES (?, ?, ?, ?, ?)";
	private static Connection connection;
	private static PreparedStatement statement;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phoneNumber");

		try 
		{
			connection = DBconnection.getConnection();
			
			PreparedStatement checkStmt =connection.prepareStatement("SELECT userId FROM user WHERE email = ?");

			checkStmt.setString(1, email);
			ResultSet rsCheck = checkStmt.executeQuery();

			if (rsCheck.next()) 
			{
				request.setAttribute("errorMsg","User already registered with this email");
				request.getRequestDispatcher("registration.jsp").forward(request, response);
				return;
			}

			int userId=0;
			
			Statement st = connection.createStatement();
			
			ResultSet executeQuery = st.executeQuery("SELECT IFNULL(MAX(userId),0)+1 FROM user");

			if (executeQuery.next())
			{
				userId = executeQuery.getInt(1);
			}
			statement = connection.prepareStatement(SQL);

			statement.setInt(1, userId);
			statement.setString(2, name);
			statement.setString(3, email);
			statement.setString(4, password);
			statement.setString(5, phone);

			int count = statement.executeUpdate();

			if (count > 0) 
			{
				request.setAttribute("sucessMsg", "Registration successful! Please login");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} 
			else
			{
				response.getWriter().println("Registration Failed");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			response.getWriter().println("Error: " + e.getMessage());
		} 
	}
}



