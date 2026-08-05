package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.Daoimpl.MenuDaoImpl;
import com.tap.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));

		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		List<Menu> menuByRestaurantId = menuDaoImpl.getMenuByRestaurantId(restaurantId);
		
		for(Menu menu : menuByRestaurantId)
		{
			System.out.println(menu);
		}
		req.setAttribute("menuByRestaurantId", menuByRestaurantId);
		
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
	}
}
