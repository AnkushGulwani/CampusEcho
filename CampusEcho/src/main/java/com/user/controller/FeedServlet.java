package com.user.controller;

import com.user.dao.ConfessionDao;
import com.user.daoimpl.ConfessionDB;
import com.user.Pojo.Confession;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/FeedServlet")
public class FeedServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConfessionDao dao = new ConfessionDB();
        List<Confession> approvedList = dao.getApprovedConfessions();

        req.setAttribute("confessions", approvedList);
        RequestDispatcher rd = req.getRequestDispatcher("feed.jsp");
        rd.forward(req, resp);
    }
}