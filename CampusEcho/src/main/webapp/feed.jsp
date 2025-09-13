<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*, com.user.Pojo.Confession"%>
<html>
<head>
<title>CampusEcho Feed</title>
<style>
body {
	font-family: 'Segoe UI', sans-serif;
	background: linear-gradient(to right, #fdfbfb, #ebedee);
	padding: 40px;
	margin: 0;
}

h1 {
	font-size: 36px;
	text-align: center;
	margin-bottom: 40px;
	color: #333;
	font-weight: 700;
	letter-spacing: 1px;
}

.card {
	background: #fff;
	border-radius: 16px;
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.08);
	padding: 24px;
	margin: 0 auto 30px;
	max-width: 600px;
	transition: transform 0.3s ease;
}

.card:hover {
	transform: translateY(-4px);
}

.tag {
	font-weight: 600;
	color: #6a5acd;
	margin-top: 10px;
	font-size: 14px;
}

.timestamp {
	font-size: 12px;
	color: #999;
	margin-bottom: 10px;
}

.reaction-btn {
	margin-right: 10px;
	background-color: #f4f4f4;
	border: none;
	padding: 10px 14px;
	border-radius: 20px;
	cursor: pointer;
	font-size: 14px;
	font-weight: 500;
	transition: background-color 0.3s ease;
}

.reaction-btn:hover {
	background-color: #e0e0e0;
}

.post-btn {
	position: fixed;
	bottom: 30px;
	right: 30px;
	background: linear-gradient(to right, #6a5acd, #836fff);
	color: white;
	border: none;
	padding: 14px 22px;
	border-radius: 50px;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	box-shadow: 0 8px 20px rgba(106, 90, 205, 0.3);
	transition: transform 0.3s ease, box-shadow 0.3s ease;
	z-index: 1000;
}

.post-btn:hover {
	transform: scale(1.05);
	box-shadow: 0 12px 28px rgba(106, 90, 205, 0.4);
}
</style>
</head>
<body>

	<h1>CampusEcho Feed</h1>

	<form action="post.jsp" method="get">
		<button type="submit" class="post-btn">✍️ Post a Confession</button>
	</form>
	<%
	List<Confession> confessions = (List<Confession>) request.getAttribute("confessions");
	if (confessions != null && !confessions.isEmpty()) {
		for (Confession c : confessions) {
	%>
	<div class="card">
		<p>
			<strong><%=c.getPostedBy()%></strong> shared:
		</p>
		<!-- NEW -->
		<p><%=c.getMessage()%></p>
		<p class="tag"><%=c.getTag()%></p>
		<p class="timestamp"><%=c.getTimestamp()%></p>



		<form action="ReactServlet" method="post" style="display: inline;">
			<input type="hidden" name="id" value="<%=c.getId()%>" /> <input
				type="hidden" name="action" value="like" />
			<button class="reaction-btn" type="submit">
				👍
				<%=c.getLikes()%></button>
		</form>

		<form action="ReactServlet" method="post" style="display: inline;">
			<input type="hidden" name="id" value="<%=c.getId()%>" /> <input
				type="hidden" name="action" value="dislike" />
			<button class="reaction-btn" type="submit">
				👎
				<%=c.getDislikes()%></button>
		</form>
	</div>
	<%
	}
	} else {
	%>
	<p>No confessions yet. Be the first to post!</p>
	<%
	}
	%>
</body>
</html>