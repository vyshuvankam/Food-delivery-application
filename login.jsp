<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}


body {
    margin: 0;
    padding: 0;
    height: 100vh;
    overflow: hidden;

    background:
    linear-gradient(rgba(0,0,0,0.5), rgba(0,0,0,0.5)),
    url('images/background food.jpg');

    background-size: 120%;
    background-position: center;
    animation: bgMove 25s ease-in-out infinite alternate;

    display: flex;
    justify-content: flex-end;
    align-items: center;
    padding-right: 160px;

    font-family: 'Segoe UI', sans-serif;
}

@keyframes bgMove {
    0% { background-position: center top; }
    100% { background-position: center bottom; }

}

@keyframes backgroundMove {
    0% {
        background-position: center top;
        background-size: 110%;
    }
    100% {
        background-position: center bottom;
        background-size: 120%;
    }
}



/* Keep your existing login styles */
.login-container {
    width: 440px;
    padding: 50px 45px;
    border-radius: 22px;

    background: rgba(255, 255, 255, 0.12);
    backdrop-filter: blur(18px);

    box-shadow: 0 20px 50px rgba(0,0,0,0.4);

    color: #fff;

    animation: fadeIn 1.2s ease-in-out;
}

@keyframes fadeIn {
    from {
        opacity: 0;
        transform: translateX(40px);
    }
    to {
        opacity: 1;
        transform: translateX(0);
    }
}
background:
linear-gradient(rgba(0,0,0,0.4), rgba(0,0,0,0.4)),
url('images/food.jpg');
background-size: cover;


.login-container h2{
	font-size: 30px;
    margin-bottom:35px;
    letter-spacing:1px;
}


.field{
    position:relative;
    margin-bottom:22px;
}

.field input{
    width:100%;
    padding:10px 14px;
    border:none;
    border-radius:8px;
    outline:none;
    font-size:14px;
}



.app-logo {
    position: absolute;
    top: 40px;
    left: 80px;
    font-size: 30px;
    font-weight: bold;
    color: white;
    letter-spacing: 2px;
    text-shadow: 0 0 15px rgba(255,255,255,0.6);
}
@keyframes logoFloat {
    0% { transform: translateY(0px); }
    50% { transform: translateY(-8px); }
    100% { transform: translateY(0px); }
}

.password-field{
    position:relative;
}

.password-field input{
    padding-right:45px;
}


#togglePassword{
    display:none;
}

.eye-icon{
    position:absolute;
    right:12px;
    top:50%;
    transform:translateY(-50%);
    cursor:pointer;
    font-size:18px;
}

#togglePassword:not(:checked) ~ input{
    -webkit-text-security: disc;
}

#togglePassword:checked ~ input{
    -webkit-text-security: none;
}

.options{
    display:flex;
    justify-content:space-between;
    align-items:center;
    font-size:13px;
    margin-bottom:18px;
}

.options label{
    cursor:pointer;
}

.options a{
    color:#fff;
    text-decoration:none;
}

.options a:hover{
    text-decoration:underline;
}

.btn{
    width:100%;
    padding:16px;
    border:none;
    border-radius:50px;
    background: linear-gradient(45deg,#ff416c,#ff4b2b);
    color:white;
    font-size:16px;
    font-weight:bold;
    cursor:pointer;
    transition:0.3s;
}

.btn:hover{
    transform:scale(1.05);
    box-shadow:0 6px 18px rgba(0,0,0,0.35);
}

/* register link */
.register{
    margin-top:18px;
    font-size:14px;
}

.register a{
    color:#fff;
    font-weight:bold;
    text-decoration:none;
}

.register a:hover{
    text-decoration:underline;
}

\.error{
    background: rgba(255,0,0,0.2);
    padding:8px;
    border-radius:6px;
    margin-bottom:12px;
    font-size:14px;
}
.particles {
    position: absolute;
    width: 100%;
    height: 100%;
    background: transparent;
    overflow: hidden;
}

.particles::before,
.particles::after {
    content: "";
    position: absolute;
    width: 200%;
    height: 200%;
    background-image: radial-gradient(white 1px, transparent 1px);
    background-size: 40px 40px;
    animation: particleMove 60s linear infinite;
    opacity: 0.08;
}

@keyframes particleMove {
    from { transform: translateY(0); }
    to { transform: translateY(-500px); }
}

.password-field {
    position: relative;
}

.password-field input {
    width: 100%;
    padding-right: 40px;
}

.eye-icon {
	color:blue;
    position: absolute;
    right: 12px;
    top: 50%;
    transform: translateY(-50%);
    cursor: pointer;
    font-size: 16px;
}
@media(max-width: 90px)
{
	body{
	justify-content: center;
	padding-right:0;
	}
	.login-container{
	width: 90%;
	}
}

</style>
</head>

<body>

	<div class="main-container">
		<div class="left-side">
			<div class="right-side">
			<div class=particles></div>

<div class="app-logo"><span id=typing></span></div>
				<div class="login-container">
					<h2>Welcome Back</h2>

					<%
						String error = (String) request.getAttribute("errorMessage");
						if (error != null) {
					%>
						<div class="error"><%= error%></div>
					<%
					}
					%>

					<form action="${pageContext.request.contextPath}/login"
						method="post">
						<!-- Email -->
						<div class="field">
							<input type="email" name="email" required placeholder="Email address"> <label>
								</label>
						</div>
						<!-- Password -->
						<div class="field password-field">
							<input type="password" id="password" name="password" required
								placeholder="Password" autocorrect="off" autocomplete="off" autocapitalize="off"> <span id="eyeToggle"
								class="eye-icon">👁</span>
						</div>
						<!-- Options -->
						<div class="options">
							<label><input type="checkbox"> Remember Me</label> <a
								href="#">Forgot Password?</a>
						</div>

						<button type="submit" class="btn">Login</button>
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
					<script>
						const text = "🍽️ FoodExpress";
						let i = 0;

						function typingEffect() {
							if (i < text.length) {
								document.getElementById("typing").innerHTML += text
										.charAt(i);
								i++;
								setTimeout(typingEffect, 100);
							}
						}

						typingEffect();
					</script>
					<div class="register">
						Don't have an account? <a href="registration.jsp">Register</a>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
