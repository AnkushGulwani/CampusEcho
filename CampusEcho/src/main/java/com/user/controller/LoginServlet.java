package com.user.controller;

import com.user.Pojo.UserInfo;
import com.user.dao.UserDao;
import com.user.daoimpl.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserInfo user = new UserInfo();
		user.setEmail(email);
		user.setPassword(password);

		UserDao dao = new UserDB();
		boolean isValid = dao.checkuserCredentials(user);

		if (isValid) {
			// ✅ Fetch name from DB
			String userName = dao.getUserNameByEmail(email); // You’ll implement this next

			HttpSession session = req.getSession();
			session.setAttribute("userName", userName); // ✅ Store name in session

			resp.sendRedirect("FeedServlet");
		} else {
			req.setAttribute("error", "Invalid email or password.");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
