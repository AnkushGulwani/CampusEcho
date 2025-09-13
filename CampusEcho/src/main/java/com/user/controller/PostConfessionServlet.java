package com.user.controller;

import com.user.Pojo.Confession;
import com.user.dao.ConfessionDao;
import com.user.daoimpl.ConfessionDB;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/PostConfessionServlet")
public class PostConfessionServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = req.getParameter("message");
		String tag = req.getParameter("tag");

		// ✅ Fetch username from session
		HttpSession session = req.getSession(false);
		String postedBy = (session != null) ? (String) session.getAttribute("userName") : null;

		if (postedBy == null || postedBy.trim().isEmpty()) {
			req.setAttribute("message", "Login required to post a confession.");
			req.getRequestDispatcher("post.jsp").forward(req, resp);
			return;
		}

		Confession c = new Confession();
		c.setMessage(message);
		c.setTag(tag);
		c.setPostedBy(postedBy); // ✅ Injected from session

		ConfessionDao dao = new ConfessionDB();
		boolean success = dao.addConfession(c);

		req.setAttribute("message", success ? "Confession submitted for approval." : "Failed to submit confession.");
		req.getRequestDispatcher("post.jsp").forward(req, resp);
	}
}