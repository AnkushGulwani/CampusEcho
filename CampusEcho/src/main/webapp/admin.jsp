<%@ page import="java.util.*, com.user.Pojo.Confession"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>Admin Panel - CampusEcho</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: #f4f4f4;
	padding: 20px;
}

.confession-card {
	background: #fff;
	border-radius: 8px;
	padding: 15px;
	margin-bottom: 20px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.tag {
	display: inline-block;
	background: #e0e0e0;
	padding: 5px 10px;
	border-radius: 20px;
	font-size: 12px;
	margin-top: 5px;
}

.actions {
	margin-top: 10px;
}

.actions button {
	padding: 6px 12px;
	margin-right: 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.approve-btn {
	background-color: #4CAF50;
	color: white;
}

.reject-btn {
	background-color: #f44336;
	color: white;
}
</style>
</head>
<body>
	<h2>Pending Confessions for Moderation</h2>

	<%
	List<Confession> pendingList = (List<Confession>) request.getAttribute("pendingList");
	if (pendingList != null && !pendingList.isEmpty()) {
		for (Confession confession : pendingList) {
	%>
	<div class="confession-card">
		<p>
			<strong>Posted by:</strong>
			<%=confession.getPostedBy()%></p>
		<p><%=confession.getMessage()%></p>
		<div class="tag"><%=confession.getTag()%></div>

		<form action="admin" method="post" class="actions">
			<input type="hidden" name="id" value="<%=confession.getId()%>" />
			<button type="submit" name="action" value="approve"
				class="approve-btn">✅ Approve</button>
			<button type="submit" name="action" value="reject" class="reject-btn">❌
				Reject</button>
		</form>
	</div>
	<%
	}
	} else {
	%>
	<p>No pending confessions at the moment.</p>
	<%
	}
	%>
</body>
</html>