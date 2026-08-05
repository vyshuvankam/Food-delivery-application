<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<%
    Integer orderId = (Integer) request.getAttribute("orderId");
    String address = (String) request.getAttribute("address");
    String paymentMethod = (String) request.getAttribute("paymentmethod");
    Double totalAmount = (Double) request.getAttribute("totalAmount");
%>
 
   


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>

<style>
/* ===== BODY ===== */
body {
    margin: 0;
    font-family: 'Poppins', sans-serif;
    background: linear-gradient(135deg, #ff9a9e, #fad0c4);
    
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

/* ===== CARD ===== */
.card {
    background: rgba(255, 255, 255, 0.95);
    backdrop-filter: blur(10px);
    padding: 45px 40px;
    border-radius: 20px;
    width: 420px;
    text-align: center;
    box-shadow: 0 20px 50px rgba(0,0,0,0.15);
    animation: fadeIn 0.6s ease-in-out;
}

/* ===== SUCCESS ICON ===== */
.success {
    width: 90px;
    height: 90px;
    margin: 0 auto 20px;
    background: #4CAF50;
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 45px;
    color: white;
    animation: pop 0.4s ease forwards;
}

/* ===== TITLE ===== */
h2 {
    margin: 10px 0;
    font-weight: 600;
    color: #333;
}

/* ===== MESSAGE ===== */
.card p {
    font-size: 14px;
    color: #666;
}

/* ===== DETAILS BOX ===== */
.details {
    text-align: left;
    background: #f9f9f9;
    padding: 18px;
    border-radius: 12px;
    margin-top: 20px;
}

.details p {
    margin: 8px 0;
    font-size: 14px;
}

.details strong {
    color: #333;
}

/* ===== BUTTON ===== */
.btn {
    display: inline-block;
    margin-top: 25px;
    padding: 10px 22px;
    background: #ff4d4d;
    color: white;
    text-decoration: none;
    border-radius: 10px;
    font-weight: 600;
    transition: 0.3s;
}

.btn:hover {
    background: #e60000;
    transform: translateY(-2px);
}

/* ===== ANIMATIONS ===== */
@keyframes pop {
    0% { transform: scale(0); }
    100% { transform: scale(1); }
}

@keyframes fadeIn {
    from {
        opacity: 0;
        transform: translateY(20px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}
</style>

</head>
<body>

<div class="card">

<div class="success">✔</div>
<h2>Order Confirmed!</h2>
<p>Your food is being prepared 🍽</p>

<div class="details">
    <p><strong>Delivery Address:</strong> <%= address %></p>
    <p><strong>Total Amount:</strong> ₹ <%= totalAmount + 30%></p>
    <p><strong>Estimated Delivery:</strong> 30-40 minutes</p>
</div>

<a href="restaurant" class="btn">Continue Ordering</a>

</div>

</body>
</html>
