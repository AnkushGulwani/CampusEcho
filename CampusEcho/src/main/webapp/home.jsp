<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>CampusEcho | Home</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #f0f4ff, #dfe9f3);
            margin: 0;
            padding: 0;
        }
        .container {
            text-align: center;
            padding: 100px 20px;
        }
        h1 {
            font-size: 48px;
            color: #2c3e50;
            margin-bottom: 10px;
        }
        p {
            font-size: 18px;
            color: #555;
            margin-bottom: 40px;
        }
        .btn {
            padding: 12px 30px;
            margin: 10px;
            font-size: 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: 0.3s ease;
        }
        .login-btn {
            background-color: #3498db;
            color: white;
        }
        .signup-btn {
            background-color: #2ecc71;
            color: white;
        }
        .btn:hover {
            opacity: 0.85;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to CampusEcho</h1>
        <p>Where student voices matter. Share, connect, and be heard.</p>
        <form action="login.jsp" method="get" style="display:inline;">
            <button class="btn login-btn">Login</button>
        </form>
        <form action="signup.jsp" method="get" style="display:inline;">
            <button class="btn signup-btn">Sign Up</button>
        </form>
    </div>
</body>
</html>s