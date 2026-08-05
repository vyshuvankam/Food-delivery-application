package com.tap.servlet;

import java.io.IOException;

import com.tap.Daoimpl.MenuDaoImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/cart")
public class CartServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

		HttpSession session = req.getSession();
		
		Cart cart = (Cart)session.getAttribute("cart");
		
		Integer oldRestaurantId = (Integer)session.getAttribute("oldRestaurantId");
		
		int restauarantId = Integer.parseInt(req.getParameter("restaurantId"));
		
		if(cart == null  || oldRestaurantId != restauarantId)
		{
			cart = new Cart();
			
			session.setAttribute("cart", cart);
			
			session.setAttribute("oldRestaurantId", restauarantId);
			
		}
		
		String action = req.getParameter("action");
		
		if(action.equals("add"))
		{
			addItemToCart(req , cart);
		}
		
		else if(action.equals("update"))
		{
			updateItemToCart(req, cart);
		}
		else if(action.equals("delete"))
		{
			deleteItemFromcart(req,cart);
		}
		
		resp.sendRedirect("cart.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doGet(req, resp);
	}
	
	
	
	
	
	private void addItemToCart(HttpServletRequest req, Cart cart) 
	{
		
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		
		int quantity = Integer.parseInt(req.getParameter("quantity"));

		
		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		
		Menu menu = menuDaoImpl.getMenu(itemId);
		
		String itemname = menu.getName();
		
		int itemPrice = menu.getPrice();
		
		CartItem cartItem = new CartItem(itemId, itemname, quantity, itemPrice);
		
		
		cart.addItem(cartItem);
		
		
		
	}

	private void updateItemToCart(HttpServletRequest req, Cart cart) 
	{
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		cart.updateItem(itemId, quantity);

	}

	private void deleteItemFromcart(HttpServletRequest req, Cart cart) 
	{
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		
		cart.removeItem(itemId);

	}

	
	
	
	

}
