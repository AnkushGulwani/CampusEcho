<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post a Confession</title>
<style>
body {
	font-family: 'Segoe UI', sans-serif;
	background: linear-gradient(to right, #fdfbfb, #ebedee);
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.form-container {
	background: white;
	padding: 40px;
	border-radius: 16px;
	box-shadow: 0 12px 30px rgba(0, 0, 0, 0.1);
	width: 420px;
	text-align: center;
}

h2 {
	font-size: 28px;
	margin-bottom: 20px;
	color: #333;
	font-weight: 700;
	letter-spacing: 1px;
}

textarea {
	width: 100%;
	height: 120px;
	padding: 14px;
	border: 1px solid #ccc;
	border-radius: 12px;
	resize: none;
	font-size: 15px;
	font-family: inherit;
	margin-bottom: 20px;
	transition: border-color 0.3s ease, box-shadow 0.3s ease;
}

textarea:focus {
	border-color: #6a5acd;
	box-shadow: 0 0 8px rgba(106, 90, 205, 0.3);
	outline: none;
}

select {
	width: 100%;
	padding: 12px;
	border-radius: 12px;
	border: 1px solid #ccc;
	font-size: 15px;
	margin-bottom: 20px;
	background-color: #f9f9f9;
	transition: border-color 0.3s ease;
}

select:focus {
	border-color: #6a5acd;
	outline: none;
}

button {
	background: linear-gradient(to right, #6a5acd, #836fff);
	color: white;
	border: none;
	padding: 12px 20px;
	border-radius: 50px;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	box-shadow: 0 8px 20px rgba(106, 90, 205, 0.3);
	transition: transform 0.3s ease, box-shadow 0.3s ease;
	margin-bottom: 10px;
}

button:hover {
	transform: scale(1.05);
	box-shadow: 0 12px 28px rgba(106, 90, 205, 0.4);
}

.back-btn {
	background-color: #f4f4f4;
	color: white;
	border: none;
	padding: 10px 18px;
	border-radius: 50px;
	font-size: 15px;
	font-weight: 500;
	cursor: pointer;
	margin-top: 10px;
	transition: background-color 0.3s ease, transform 0.2s ease;
}

.back-btn:hover {
	background-color: #e0e0e0;
	transform: translateY(-2px);
}

.alert {
	padding: 10px;
	border-radius: 8px;
	margin-bottom: 20px;
	font-weight: 600;
	color: #2f7a4f;
	background-color: #e6ffed;
}
</style>
</head>
<body>
	<div class="form-container">
		<h2>Post a Confession</h2>

		<%
		String msg = (String) request.getAttribute("message");
		if (msg != null) {
		%>
		<div class="alert"><%=msg%></div>
		<%
		}
		%>

		<form action="PostConfessionServlet" method="post">
			
			<textarea name="message" placeholder="Your confession..." required></textarea>
			<select name="tag">
				<option value="#placement">#placement</option>
				<option value="#hostel">#hostel</option>
				<option value="#crush">#crush</option>
				<option value="#gossip">#gossip</option>
				<option value="#help">#help</option>
			</select>
			<button type="submit">Submit</button>
		</form>

		<!-- 🔙 Back to Feed Button -->
		<form action="FeedServlet" method="get">
			<button type="submit" class="back-btn">🔙 Back to Feed</button>
		</form>
	</div>
</body>
</html>