package com.user.controller;

import com.user.dao.ConfessionDao;
import com.user.daoimpl.ConfessionDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ReactServlet")
public class ReactServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("action");

		ConfessionDao dao = new ConfessionDB();
		boolean success = false;

		if ("like".equals(action)) {
			success = dao.updateLikes(id);
		} else if ("dislike".equals(action)) {
			success = dao.updateDislikes(id);
		}

		
		// Redirect back to feed
		response.sendRedirect("FeedServlet");
	}
}