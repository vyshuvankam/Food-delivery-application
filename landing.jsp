<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>FoodExpress</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>

body{
    margin:0;
    font-family: 'Segoe UI', sans-serif;
    background:#f5f5f5;
}

/* HERO SECTION */
.hero{
    height:100vh;
    background:linear-gradient(rgba(0,0,0,0.55), rgba(0,0,0,0.55)),
    url("images/landing.jpg") center/cover no-repeat;
    color:white;
    text-align:center;
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
}
.hero{
    height:100vh;
    background: linear-gradient(rgba(0,0,0,0.55), rgba(0,0,0,0.55)),
                url("images/landing.jpg") center/cover no-repeat;
    animation: moveBg 25s linear infinite;
}

@keyframes moveBg{
    0% { background-position:center top; }
    100% { background-position:center bottom; }
}

.hero h1{
    font-size:48px;
    margin-bottom:10px;
}

.hero p{
    font-size:20px;
    margin-bottom:25px;
}

/* SEARCH BAR */
.search-box{
    width:60%;
    max-width:500px;
    display:flex;
    background:white;
    border-radius:30px;
    overflow:hidden;
}

.search-box input{
    border:none;
    padding:15px;
    flex:1;
    font-size:16px;
}

.search-box button{
    background:#fc8019;
    border:none;
    padding:0 25px;
    color:white;
    font-size:16px;
    cursor:pointer;
}

/* BUTTONS */
.btns{
    margin-top:20px;
}

.btn{
    padding:12px 25px;
    border:none;
    border-radius:25px;
    margin:5px;
    font-size:16px;
    cursor:pointer;
}

.login{ background:#fc8019; color:white; }
.register{ background:white; color:#333; }

/* SECTION TITLE */
.section-title{
    text-align:center;
    margin:40px 0 20px;
    font-size:28px;
    font-weight:bold;
}

/* CATEGORIES */
.categories{
    display:flex;
    justify-content:center;
    gap:30px;
    flex-wrap:wrap;
}

.cat{
    text-align:center;
}

.cat img{
    width:120px;
    height:120px;
    border-radius:50%;
    object-fit:cover;
}

/* FEATURES */
.features{
    display:flex;
    justify-content:center;
    gap:40px;
    margin:40px;
    flex-wrap:wrap;
}

.feature{
    background:white;
    padding:20px;
    border-radius:15px;
    width:200px;
    text-align:center;
    box-shadow:0 4px 12px rgba(0,0,0,0.1);
}

/* RESTAURANT CARDS */
.restaurants{
    display:flex;
    justify-content:center;
    gap:25px;
    flex-wrap:wrap;
    margin-bottom:40px;
}

.card{
    background:white;
    width:250px;
    border-radius:15px;
    overflow:hidden;
    box-shadow:0 4px 12px rgba(0,0,0,0.1);
}

.card img{
    width:100%;
    height:160px;
    object-fit:cover;
}

.card-body{
    padding:15px;
}

.rating{
    color:green;
    font-weight:bold;
}

footer{
    background:#222;
    color:white;
    text-align:center;
    padding:20px;
}

</style>
</head>

<body>

<!-- HERO -->
<div class="hero">
    <h1>FoodExpress</h1>
    <p>Craving Something Delicious?</p>
    <p>Delivering happiness at your doorstep</p>

   <div class="btn explore" onclick="location.href='restaurant'">Explore Restaurants</div>
    <div class="btns">
        <button class="btn login" onclick="location.href='login.jsp'">Login</button>
        <button class="btn register" onclick="location.href='registration.jsp'">Register</button>
    </div>
</div>

<!-- CATEGORIES -->
<div class="section-title">Popular Categories</div>

<div class="categories">
    <div class="cat">
        <img src="images/pizza.jpg">
        <p>Pizza</p>
    </div>
    <div class="cat">
        <img src="images/burger.webp">
        <p>Burgers</p>
    </div>
    <div class="cat">
        <img src="images/chicken biryani.jpg">
        <p>Biryani</p>
    </div>
</div>

<!-- FEATURES -->
<div class="section-title">Why Choose Us</div>

<div class="features">
    <div class="feature"> ⚡ Fast Delivery</div>
    <div class="feature"> 🍴 Fresh Food</div>
    <div class="feature"> ⭐ Top Rated</div>
    <div class="feature"> 💳  Easy Payment</div>
</div>

<!-- RESTAURANTS -->
<div class="section-title">Featured Restaurants</div>

<div class="restaurants">
    

    <div class="card">
        <img src="images/burger.webp">
        <div class="card-body">
            <h3>Foodie Stop</h3>
            <p class="rating">★ 4.2</p>
            <p>25 mins • ₹350 for two</p>
        </div>
    </div>

    <div class="card">
        <img src="images/chicken biryani.jpg">
        <div class="card-body">
            <h3>Meghana</h3>
            <p class="rating">★ 4.3</p>
            <p>35 mins • ₹450 for two</p>
        </div>
    </div>
</div>

<footer>
    © 2026 FoodExpress • Delivering Happiness 🍔
</footer>

</body>
</html>