<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Signup</title>
<style>
body {
    font-family: 'Segoe UI', sans-serif;
    background: linear-gradient(to right, #e0eafc, #cfdef3);
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    overflow: hidden;
}

.brand {
    position: absolute;
    top: 40px;
    text-align: center;
    width: 100%;
    z-index: 10;
}

.brand h1 {
    font-size: 52px;
    color: black;
    font-weight: 800;
    letter-spacing: 2px;
    text-shadow: 0 4px 12px rgba(0, 0, 0, 0.3);
    margin: 0;
    animation: glowFade 2s ease-in-out forwards;
}

@keyframes glowFade {
    0% {
        opacity: 0;
        transform: translateY(-20px);
        text-shadow: none;
    }
    100% {
        opacity: 1;
        transform: translateY(0);
        text-shadow: 0 0 20px rgba(255, 255, 255, 0.6);
    }
}

.form-box {
    background: rgba(255, 255, 255, 0.95);
    padding: 40px;
    border-radius: 14px;
    box-shadow: 0 12px 30px rgba(0, 0, 0, 0.2);
    width: 380px;
    transition: all 0.3s ease;
}

h2 {
    text-align: center;
    margin-bottom: 25px;
    color: #333;
    font-size: 24px;
    font-weight: 600;
}

input, button {
    width: 100%;
    padding: 12px;
    margin: 12px 0;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 15px;
    transition: all 0.3s ease;
}

input:focus {
    border-color: #6a5acd;
    box-shadow: 0 0 6px rgba(106, 90, 205, 0.3);
    outline: none;
}

button {
    background-color: #6a5acd;
    color: white;
    border: none;
    font-weight: bold;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

button:hover {
    background-color: #5a4bb7;
    transform: translateY(-2px);
}

.login-link {
    text-align: center;
    margin-top: 15px;
}

.login-link a {
    color: #6a5acd;
    text-decoration: none;
    font-weight: 500;
}

.login-link a:hover {
    text-decoration: underline;
}

.alert {
    padding: 10px;
    border-radius: 5px;
    margin-bottom: 15px;
    text-align: center;
    font-weight: bold;
}

.alert-success {
    background-color: #e6ffed;
    color: #2f7a4f;
}

.alert-error {
    background-color: #ffe6e6;
    color: #a94442;
}
</style>
</head>
<body>
	<div class="brand">
		<h1>CampusEcho</h1>
	</div>
	<div class="form-box">
		<h2>Create Account</h2>

		<%
		if (request.getAttribute("error") != null) {
		%>
		<div class="alert alert-error">
			<%=request.getAttribute("error")%>
		</div>
		<%
		}
		%>

		<%
		if (request.getAttribute("message") != null) {
		%>
		<div class="alert alert-success">
			<%=request.getAttribute("message")%>
		</div>
		<%
		}
		%>

		<form action="SignupServlet" method="post">
			<input type="text" name="name" placeholder="Username" required /> <input
				type="email" name="email" placeholder="Email Address" required /> <input
				type="password" name="password" placeholder="Password" required />
			<button type="submit">Sign Up</button>
		</form>
		<div class="login-link">
			Already have an account? <a href="login.jsp">Login here</a>
		</div>
	</div>
</body>
</html>