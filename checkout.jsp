<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>

<style>
/* ===== PAGE BACKGROUND ===== */
/* ===== PAGE ===== */
body {
    margin: 0;
    font-family: 'Poppins', sans-serif;
    background: #f4f6f9;
}

/* ===== MAIN WRAPPER ===== */
.checkout-wrapper {
    width: 90%;
    max-width: 1100px;
    margin: 50px auto;
    display: flex;
    gap: 40px;
}

/* ===== LEFT SIDE FORM ===== */
.checkout-form {
    flex: 2;
    background: #ffffff;
    padding: 35px;
    border-radius: 18px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.08);
}

.checkout-form h2 {
    margin-bottom: 25px;
    font-weight: 600;
}

/* LABEL */
label {
    display: block;
    margin-top: 18px;
    font-size: 14px;
    font-weight: 500;
}

/* INPUTS */
textarea,
select {
    width: 100%;
    margin-top: 8px;
    padding: 12px;
    border-radius: 10px;
    border: 1px solid #ddd;
    font-size: 14px;
    background: #fafafa;
    transition: 0.3s;
}

textarea {
    height: 90px;
    resize: none;
}

textarea:focus,
select:focus {
    border-color: #ff4d4d;
    box-shadow: 0 0 0 3px rgba(255,77,77,0.15);
    background: #fff;
}

/* BUTTON */
input[type="submit"] {
    margin-top: 30px;
    width: 100%;
    padding: 12px;
    border-radius: 12px;
    border: none;
    background: #ff4d4d;
    color: white;
    font-weight: 600;
    cursor: pointer;
    transition: 0.3s;
}

input[type="submit"]:hover {
    background: #e60000;
    transform: translateY(-2px);
}

/* ===== RIGHT SIDE SUMMARY ===== */
.order-summary {
    flex: 1;
    background: #ffffff;
    padding: 30px;
    border-radius: 18px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.08);
    height: fit-content;
}

.order-summary h3 {
    margin-bottom: 20px;
}

.summary-row {
    display: flex;
    justify-content: space-between;
    margin: 12px 0;
    font-size: 14px;
}

.total-row {
    font-weight: bold;
    font-size: 16px;
    border-top: 1px solid #eee;
    padding-top: 15px;
}

/* ===== RESPONSIVE ===== */
@media (max-width: 900px) {
    .checkout-wrapper {
        flex-direction: column;
    }
}
</style>

</head>
<body>
<div class="checkout-wrapper">

    <div class="checkout-form">
        <h2>Checkout</h2>

        <form action="Checkout" method="post">

            <label for="address">Delivery Address</label>
            <textarea name="address" required></textarea>

            <label for="paymentMethod">Payment Method</label>
            <select name="paymentMethod" required>
                <option value="Credit Card">Credit Card</option>
                <option value="Debit Card">Debit Card</option>
                <option value="Cash on Delivery">Cash on Delivery</option>
            </select>

            <input type="submit" value="Place Order">

        </form>
    </div>

    <div class="order-summary">
        <h3>Order Summary</h3>

        

        <div class="summary-row">
            <span>Delivery Fee</span>
            <span>₹ 30</span>
        </div>

        <div class="summary-row total-row">
            <span>Total</span>
            <span>₹ ${cart.totalPrice + 30}</span>
        </div>

    </div>

</div>

</body>
</html>
