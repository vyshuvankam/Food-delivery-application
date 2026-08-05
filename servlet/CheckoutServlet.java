package com.tap.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import com.tap.Daoimpl.OrderItemsDaoImpl;
import com.tap.Daoimpl.OrdersdaoImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.OrderItems;
import com.tap.model.Orders;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Checkout")
public class CheckoutServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		
		Cart cart = (Cart) session.getAttribute("cart");
		
		Integer user = (Integer) session.getAttribute("userId");
		
		int restaurantId = (Integer) session.getAttribute("oldRestaurantId");
		
		String address = req.getParameter("address");
		
		String paymentMethod = req.getParameter("paymentMethod");
		
		if(user == null)
		{
			session.setAttribute("redirectAfterLogin", "Checkout");
			resp.sendRedirect("login.jsp");
			return;
		}
		
		if(cart !=null && user != null && !cart.getItems().isEmpty())
		{
			
			Orders order = new Orders();
			
			order.setUserId(user);
			order.setRestaurantId(restaurantId);
			order.setOrderdate(new Timestamp(System.currentTimeMillis()));
			order.setAddress(address);
			order.setStatus("pending");
			order.setPaymentMethod(paymentMethod);
			
			double totalAmount = 0.0;
			
			for (CartItem item : cart.getItems().values()) 
			{
				
				totalAmount = totalAmount +item.getQuantity() * item.getPrice();
				
			}
			order.setTotalAmount(totalAmount);
			OrdersdaoImpl ordersdaoImpl = new OrdersdaoImpl();
			
			int orderId = ordersdaoImpl.addOrder(order);
			
			for (CartItem item : cart.getItems().values()) 
			{
				int itemId = item.getItemId();
				int quantity = item.getQuantity();
				double totalPrice = item.getTotalPrice();
				
				OrderItems orderItem = new OrderItems();
				
				orderItem.setOrderId(orderId);
				orderItem.setMenuId(itemId);
				orderItem.setQuantity(quantity);
				orderItem.setTotalPrice(totalPrice);
				
				OrderItemsDaoImpl orderItemsDaoImpl = new OrderItemsDaoImpl();
				
				orderItemsDaoImpl.addOrderItem(orderItem);
			}
			
			req.setAttribute("orderId", orderId);
			req.setAttribute("address", address);
			req.setAttribute("paymentMethod", paymentMethod);
			req.setAttribute("totalAmount", totalAmount);

			RequestDispatcher rd = req.getRequestDispatcher("/orderConfirmation.jsp");
			rd.forward(req, resp);
			return;
			
			
		}
		else
		{
			resp.sendRedirect("cart.jsp");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

}
