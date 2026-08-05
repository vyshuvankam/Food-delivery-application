<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page  import="java.util.List , com.tap.model.Menu" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Restaurant Menu</title>

<style>
/* ===== Global Reset ===== */
/* ===== BODY ===== */
body {
    margin: 0;
    font-family: 'Poppins', sans-serif;
    background: #f4f6f9;
}

/* ===== HEADER ===== */
.header {
    background: linear-gradient(135deg, #ff512f, #dd2476);
    color: white;
    padding: 22px;
    text-align: center;
    font-size: 24px;
    font-weight: 600;
    letter-spacing: 1px;
}

/* ===== CONTAINER ===== */
.menu-container {
    width: 90%;
    margin: 40px auto;
}

/* ===== GRID ===== */
.grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
    gap: 25px;
}

/* ===== CARD ===== */
.card {
    background: #ffffff;
    border-radius: 18px;
    overflow: hidden;
    box-shadow: 0 10px 25px rgba(0,0,0,0.08);
    transition: all 0.3s ease;
    display: flex;
    flex-direction: column;
}

.card:hover {
    transform: translateY(-8px);
    box-shadow: 0 15px 35px rgba(0,0,0,0.15);
}

/* ===== IMAGE SECTION ===== */
.media {
    position: relative;
}

.media img {
    width: 100%;
    height: 190px;
    object-fit: cover;
}

/* ===== PRICE BADGE ===== */
.priceTag {
    position: absolute;
    top: 12px;
    left: 12px;
    background: #ffffff;
    color: #ff512f;
    padding: 5px 10px;
    border-radius: 8px;
    font-size: 14px;
    font-weight: 600;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
}

/* ===== RATING BADGE ===== */
.rating {
    position: absolute;
    top: 12px;
    right: 12px;
    background: #28a745;
    color: white;
    padding: 4px 8px;
    border-radius: 6px;
    font-size: 13px;
    font-weight: 500;
}

/* ===== CONTENT ===== */
.content {
    padding: 18px;
    flex: 1;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}

.name {
    margin: 0;
    font-size: 18px;
    font-weight: 600;
    color: #333;
}

.desc {
    font-size: 14px;
    color: #777;
    margin-top: 8px;
    line-height: 1.4;
}

/* ===== FORM BUTTON ===== */
form {
    margin-top: 15px;
}

/* ===== SIMPLE ADD TO CART BUTTON ===== */

input[type="submit"] {
    width: 100%;
    padding: 8px;
    border: 1.5px solid #ff4d4d;
    border-radius: 8px;
    background: transparent;
    color: #ff4d4d;
    font-size: 14px;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.3s ease;
}

/* Hover Effect */
input[type="submit"]:hover {
    background: #ff4d4d;
    color: white;
}

/* Dark Mode Version */
body.dark input[type="submit"] {
    border: 1.5px solid #ff7676;
    color: #ff7676;
}

body.dark input[type="submit"]:hover {
    background: #ff7676;
    color: black;
}
/* ===== RESPONSIVE ===== */
@media (max-width: 768px) {
    .menu-container {
        width: 95%;
    }
}
/* ================= CATEGORY FILTER ================= */
.category-filter {
    display: flex;
    gap: 15px;
    margin: 25px 0;
    flex-wrap: wrap;
}

.category-filter button {
    padding: 8px 18px;
    border-radius: 20px;
    border: none;
    background: #ffffff;
    color: #444;
    font-size: 14px;
    font-weight: 500;
    cursor: pointer;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    transition: 0.3s;
}

.category-filter button:hover {
    background: #ff512f;
    color: white;
}

.category-filter .active {
    background: linear-gradient(135deg, #ff512f, #dd2476);
    color: white;
}

/* Dark Mode Filter */
body.dark .category-filter button {
    background: #1e1e1e;
    color: #ddd;
}

body.dark .category-filter button:hover {
    background: #ff512f;
}
/* ================= DARK MODE ================= */
body.dark {
    background: #121212;
    color: #e0e0e0;
}

body.dark .header {
    background: linear-gradient(135deg, #232526, #414345);
}

body.dark .card {
    background: #1e1e1e;
    box-shadow: 0 10px 30px rgba(0,0,0,0.6);
}

body.dark .name {
    color: #ffffff;
}

body.dark .desc {
    color: #b0b0b0;
}

body.dark .priceTag {
    background: #2b2b2b;
    color: #ff7676;
}

body.dark .rating {
    background: #2ecc71;
}

body.dark input[type="submit"] {
    background: linear-gradient(135deg, #ff416c, #ff4b2b);
}

body.dark input[type="submit"]:hover {
    transform: scale(1.05);
}
</style>
</head>

<body>

<div class="header">🍽 Restaurant Menu</div>

<div class="menu-container">

    <section class="grid" aria-label="menu items">
    <%
    
    List<Menu> menuByRestaurantId=(List<Menu>)request.getAttribute("menuByRestaurantId");
    
    for(Menu menu : menuByRestaurantId)
	{
    	%>
		<article class="card">
			<div class="media">
				<span class="priceTag"><%=menu.getPrice() %></span> 
				<span class="rating"><%=menu.getRating() %></span> 
				<img alt="<%=menu.getName() %>" src="<%=menu.getImageUrl()%>">
			</div>
			<div class="content">

				<h3 class="name"><%=menu.getName() %></h3>
				<p class="desc"><%=menu.getDescription() %></p>
			</div>
			<div>
			
			<form action="cart">
			
			<input type="hidden" name="itemId" value="<%=menu.getMenuId()%>">
			
			<input type="hidden" name="restaurantId" value="<%=menu.getRestaurantId() %>">
			
			<input type="hidden" name="quantity" value="1">
			
			<input type="hidden" name="action" value="add">
			
			<input type="submit" value="Add to cart">
			
			</form>
	
			</div>

		</article>
	
	<%
	
	}
    
   %>
    </section>


	</div>

</body>
</html>
