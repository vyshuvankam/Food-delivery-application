<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*, com.tap.model.Restaurant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoodExpress - Restaurants</title>

<style>

/* RESET */
body{
    margin:0;
    font-family:Segoe UI, sans-serif;
    background:#f5f6fa;
}

/* NAVBAR */
.navbar{
    background:#ff4d4d;
    color:white;
    padding:16px 40px;
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.logo{
    font-size:22px;
    font-weight:bold;
}

.nav-links a{
    color:white;
    text-decoration:none;
    margin-left:20px;
    font-weight:500;
}

/* HERO BANNER */
.hero{
    height:260px;
    background:url("images/food-banner.jpg") center/cover no-repeat;
    display:flex;
    align-items:center;
    justify-content:center;
}

.hero-box{
    background:rgba(0,0,0,0.45);
    padding:25px 35px;
    border-radius:10px;
    text-align:center;
    color:white;
}

.hero-box input{
    margin-top:12px;
    padding:12px;
    width:260px;
    border:none;
    border-radius:25px;
}

/* FILTER BUTTONS */
.filters{
    text-align:center;
    margin:25px 0 10px 0;
}

.filters button{
    border:none;
    padding:8px 18px;
    margin:6px;
    border-radius:20px;
    background:#e0e0e0;
    cursor:pointer;
    transition:0.3s;
}

.filters button:hover,
.filters .active{
    background:#ff4d4d;
    color:white;
}

/* GRID */
.restaurant-grid{
    padding:30px 60px 50px;
    display:grid;
    grid-template-columns: repeat(auto-fit, minmax(340px, 1fr));
    gap:35px;
}

/* CARD */
.card{
    background:white;
    border-radius:18px;
    overflow:hidden;
    text-decoration:none;
    color:black;
    box-shadow:0 6px 18px rgba(0,0,0,0.1);
    transition:0.3s;
}
.order-btn{
    margin-top:15px;
    padding:10px 22px;
    border:none;
    border-radius:25px;
    background:#ff4d4d;
    color:white;
    font-size:15px;
    cursor:pointer;

    opacity:0;
    transform:translateY(10px);
    transition:0.3s ease;
}

/* show on hover */
.restaurant-card:hover .order-btn{
    opacity:1;
    transform:translateY(0);
}

.card:hover{
    transform:translateY(-8px);
    box-shadow:0 12px 28px rgba(0,0,0,0.18);
}

/* IMAGE */
.img-box{
    position:relative;
    height:170px;
    overflow:hidden;
}

.img-box img{
    width:100%;
    height:100%;
    object-fit:cover;
    transition:0.4s;
}

.card:hover img{
    transform:scale(1.1);
}

/* RATING BADGE */
.rating{
    position:absolute;
    bottom:12px;
    right:12px;
    background:white;
    padding:6px 12px;
    border-radius:10px;
    font-size:15px;
    font-weight:bold;
}

/* CONTENT */
.card-body{
    padding:18px;
}
.card-body h3{
    margin:0;
    font-size:22px;
    font-weight:600;
}

.cuisine{
    color:#777;
    font-size:16px;
    margin-top:6px;
}

.meta{
    display:flex;
    justify-content:space-between;
    margin-top:14px;
    font-size:15px;
}

.time{
    background:#f2f2f2;
    padding:4px 10px;
    border-radius:8px;
}

.address{
    color:#777;
}
@media(max-width:768px){
    .restaurant-grid{
        grid-template-columns:1fr;
        padding:20px;
    }
}

</style>
</head>
<body>

<!-- NAVBAR -->
<div class="navbar">
    <div class="logo">FoodExpress</div>
    <div class="nav-links">
        <a href="landing.jsp">Home</a>
        <a href="login.jsp">Login</a>
        <a href="cart.jsp">Cart</a>
    </div>
</div>

<!-- HERO -->


<!-- FILTERS -->


<!-- RESTAURANTS GRID -->
<div class="restaurant-grid">

<%
List<Restaurant> allRestaurants =
    (List<Restaurant>) request.getAttribute("allRestaurants");

if(allRestaurants != null){
    for(Restaurant r : allRestaurants){
%>

<a class="card" href="menu?restaurantId=<%=r.getRestaurantId()%>">

    <div class="img-box">
        <img src="<%=r.getImageUrl()%>">
        <div class="rating">⭐ <%=r.getRating()%></div>
    </div>

    <div class="card-body">
        <h3><%=r.getRestaurantName()%></h3>
        <div class="cuisine"><%=r.getCuisineType()%></div>

        <div class="meta">
            <div class="time"><%=r.getETA()%> min</div>
            <div class="address"><%=r.getAddress()%></div>
        </div>
    </div>

</a>

<%
    }
}
%>

</div>

</body>
</html>