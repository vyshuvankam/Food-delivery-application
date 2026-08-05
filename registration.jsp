<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

body {
    margin: 0;
    height: 100vh;
    background: url('images/food2.avif') no-repeat center center/cover;
   
    display: flex;
    justify-content: center;
    align-items: center;
    background-size: 120%;
    background-position: center;
    animation: bgMove 25s ease-in-out infinite alternate;

    display: flex;
    justify-content: flex-end;
    align-items: center;
    padding-right: 350px;

    font-family: 'Segoe UI', sans-serif;
}

@keyframes zoomBG {
    0% {
background-size: 100;
    }
    100% {
        background-size: 110;
    }
}

.register-container {
    width: 400px;
    padding: 30px;
    border-radius: 15px;

    background: rgba(255, 255, 255, 0.15);
    backdrop-filter: blur(10px);

    box-shadow: 0 8px 32px rgba(0, 0, 0, 0.3);
    color: white;
}

.register-container h2 {
	margin-bottom: 20px;
	letter-spacing: 1px;
}

.input-group {
	margin-bottom: 15px;
	text-align: left;
}

.input-group label {
	font-size: 14px;
	font-weight: 500;
}

.input-group input {
	width: 100%;
	padding: 10px;
	margin-top: 6px;
	border: none;
	border-radius: 8px;
	outline: none;
	
}

.input-group input:focus {
	box-shadow: 0 0 5px #fff;
}

.btn {
	width: 100%;
	padding: 12px;
	margin-top: 10px;
	border: none;
	border-radius: 25px;
	background: linear-gradient(90deg, #ff512f, #dd2476);
	color: #333;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	transition: 0.3s;
}

.btn:hover {
	transform: scale(1.05);
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
}

.login-link {
	margin-top: 15px;
	font-size: 14px;
}

.login-link a {
	color: #fff;
	text-decoration: none;
	font-weight: bold;
}

.login-link a:hover {
	text-decoration: underline;
}

.error-box {
	background: #ffe6e6;
	color: #b30000;
	padding: 12px;
	border-radius: 8px;
	margin-bottom: 15px;
	font-weight: bold;
	text-align: center;
	border: 1px solid #ff9999;
}

.success-box {
    background: linear-gradient(135deg,#e6ffed,#ccffd9);
    color: #0f5132;
    padding: 14px;
    border-radius: 10px;
    margin-bottom: 18px;
    font-weight: 600;
    text-align: center;
    border-left: 5px solid #2ecc71;
    box-shadow: 0 4px 10px rgba(0,0,0,0.08);
    animation: fadeIn 0.3s ease-in;
}
</style>

</head>
<body>

	<div class="register-container">
		<h2>Create Account</h2>

		<%
		String err = (String) request.getAttribute("errorMsg");
		%>
		<%
		if (err != null) {
		%>
		<div class="error-box"><%=err%></div>
		<%
		}
		%>

		<%
		String success = (String) request.getAttribute("successMsg");
		%>
		<%
		if (success != null) {
		%>
		<div class="success-box"><%=success%></div>
		<%
		}
		%>

		<form action="register" method="post">

			<div class="input-group">
				<label>Full Name</label> <input type="text" name="name" required>
			</div>

			<div class="input-group">
				<label>Email</label> <input type="email" name="email" required>
			</div>

			<div class="input-group">
				<label>Phone Number</label> <input type="text" name="phone" required autocorrect="off" autocomplete="off" autocapitalize="off">
			</div>

			<div class="input-group">
				<label>Password</label> <input type="password" name="password"
					required autocorrect="off" autocomplete="off" autocapitalize="off">
			</div>

			<div class="input-group">
				<label>Confirm Password</label> <input type="password"
					name="confirmPassword" required>
			</div>

			<button type="submit" class="btn">Register</button>
		</form>
		<script>
						const eye = document.getElementById("eyeToggle");
						const password = document.getElementById("password");
						eye.addEventListener(
										"click",
										function() {
											password.type = password.type === "password" ? "text"
													: "password";
										});
					</script>

		<div class="login-link">
			Already have an account? <a href="login.jsp">Login</a>
		</div>
	</div>

</body>
</html>
