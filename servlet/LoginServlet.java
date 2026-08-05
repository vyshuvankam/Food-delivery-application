package com.tap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.tap.connection.DBconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	private static final String SQL = "SELECT userId, userName FROM user WHERE email=? AND password=?";
	private static PreparedStatement statement;
	private static ResultSet res;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		

		try 
		{
			Connection connection = DBconnection.getConnection();

			statement = connection.prepareStatement(SQL);

			statement.setString(1, email);
			statement.setString(2, password);

			res = statement.executeQuery();

			if (res.next()) 
			{
				HttpSession session = request.getSession();
				session.setAttribute("userId", res.getInt("userId"));
				session.setAttribute("userName", res.getString("userName"));

				String redirectPage = (String) session.getAttribute("redirectAfterLogin");

				if (redirectPage != null) {
				    session.removeAttribute("redirectAfterLogin");
				    response.sendRedirect(request.getContextPath() + "/" + redirectPage);
				} else {
				    response.sendRedirect(request.getContextPath() + "/restaurant");
				}			} 
			else {
			    request.setAttribute("errorMessage","Invalid Email or Password");
			    request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			response.getWriter().println("Login Error: " + e.getMessage());
		} 
		
	}
}


