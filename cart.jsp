<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ page  import=" com.tap.model.Cart , com.tap.model.CartItem" %>
    
<!DOCTYPE html>
<html>
<head>
    <title>My Cart</title>
    <link rel="stylesheet" href="cart.css">
    <style type="text/css">
    * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

<style>

body {
    font-family: 'Poppins', sans-serif;
    background: linear-gradient(135deg, #ffecd2, #fcb69f);
    margin: 0;
    padding: 0;
}

.cart-container {
    width: 85%;
    margin: 40px auto;
    display: flex;
    gap: 30px;
}

.cart-left {
    flex: 2;
    background: #ffffff;
    padding: 25px;
    border-radius: 20px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.1);
}

.cart-left h2 {
    margin-bottom: 20px;
    font-size: 26px;
    color: #333;
}

.cart-item {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 18px;
    border-bottom: 1px solid #eee;
    transition: 0.3s;
}

.cart-item:hover {
    background: #f9f9f9;
    transform: scale(1.02);
}

.cart-item-details h3 {
    margin: 0;
    font-size: 18px;
    color: #444;
}

.cart-item-details p {
    margin: 5px 0;
    color: #777;
}

.quantity-control {
    display: flex;
    align-items: center;
    gap: 10px;
}

.quantity-button {
    background: #ff6b6b;
    border: none;
    color: white;
    padding: 6px 12px;
    border-radius: 8px;
    cursor: pointer;
    transition: 0.3s;
}

.quantity-button:hover {
    background: #ff3b3b;
}

.remove-btn {
    background: #333;
    color: white;
    padding: 6px 14px;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    transition: 0.3s;
}

.remove-btn:hover {
    background: #000;
}

.total {
    margin-top: 20px;
    font-size: 20px;
    font-weight: bold;
    text-align: right;
    color: #333;
}

.add-more-items {
    margin-top: 20px;
    text-align: center;
}

.add-more-items a {
    text-decoration: none;
    background: #4CAF50;
    color: white;
    padding: 10px 20px;
    border-radius: 10px;
    transition: 0.3s;
}

.add-more-items a:hover {
    background: #45a049;
}

.proceed-to-checkout-btn {
    width: 100%;
    margin-top: 20px;
    padding: 14px;
    font-size: 16px;
    background: linear-gradient(135deg, #ff512f, #dd2476);
    border: none;
    color: white;
    border-radius: 12px;
    cursor: pointer;
    transition: 0.3s;
}

.proceed-to-checkout-btn:hover {
    transform: scale(1.05);
}

.empty-cart {
    text-align: center;
    font-size: 18px;
    color: #555;
    margin-top: 40px;
}

</style>
    </style>
</head>
<body>

	<div class="cart-container">

		<div class="cart-left">
			<h2>Your Cart</h2>

			<%
			Cart cart = (Cart) session.getAttribute("cart");

			Integer restaurantId = (Integer) session.getAttribute("restaurantId");

			if (cart != null && !cart.getItems().isEmpty()) {
				for (CartItem item : cart.getItems().values()) {
			%>

			<div class="cart-item">
				<div class="cart-item-details">
					<h3><%=item.getName()%></h3>
					<p>
						Price: ₹<%=item.getPrice()%></p>
					<p>
						Total: ₹<%=item.getTotalPrice()%>
					</p>



					<div class="quantity-control">

						<form action="cart" method="post" style="display: inline">
							<input type="hidden" name="itemId" value="<%=item.getItemId()%>">
							<input type="hidden" name="action" value="update"> <input
								type="hidden" name="quantity"
								value="<%=item.getQuantity() + 1%>"> <input
								type="hidden" name="restaurantId"
								value="<%=session.getAttribute("oldRestaurantId")%>">
							<button class="quantity-button">+</button>
						</form>
						<p><%=item.getQuantity()%></p>

						<form action="cart" method="post" style="display: inline">

							<input type="hidden" name="itemId" value="<%=item.getItemId()%>">

							<input type="hidden" name="action" value="update"> <input
								type="hidden" name="quantity"
								value="<%=item.getQuantity() - 1%>"> <input
								type="hidden" name="restaurantId"
								value="<%=session.getAttribute("oldRestaurantId")%>">

							<button class="quantity-button"
								<%=item.getQuantity() <= 1 ? "disabled" : ""%>>-</button>

						</form>
					</div>

					<form action="cart" method="post">

						<input type="hidden" name="itemId" value="<%=item.getItemId()%>">

						<input type="hidden" name="restaurantId"
							value="<%=session.getAttribute("oldRestaurantId")%>"> <input
							type="hidden" name="action" value="delete">

						<button class="remove-btn">Remove</button>

					</form>
				</div>

			</div>
			<%
			}
			%>
			<div class="total">
				Grand Total: ₹<%=cart.getTotalPrice()%>
			</div>

			<div class="add-more-items">
				<a
					href="menu?restaurantId=<%=session.getAttribute("oldRestaurantId")%>"
					class="btn add-more-items-btn"> Add More Items </a>
			</div>


			<%
        }
        else
    	{
    		%>
			<p class="empty-cart">🛒 Your Cart is Empty</p>
			<div class="add-more-items">
					<a href="restaurant">Add Items</a>
			
			</div>
			<% 
        }
        %>
        <%
        if(session.getAttribute("cart") != null)
        {
        %>
        <form action="checkout.jsp" method="post">
        	<input type="submit" value="proceed to Checkout" class="btn proceed-to-checkout-btn">
        
        </form>
		<%} %>
		
	</div>
	</div>

</body>
</html>
