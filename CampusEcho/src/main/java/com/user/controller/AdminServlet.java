package com.user.controller;

import com.user.dao.ConfessionDao;
import com.user.daoimpl.ConfessionDB;
import com.user.Pojo.Confession;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private ConfessionDao dao;

    @Override
    public void init() throws ServletException {
        dao = new ConfessionDB(); // No need for external connection here
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Confession> pending = dao.getPendingConfessions();
        request.setAttribute("pendingList", pending);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");

        if ("approve".equals(action)) {
            dao.approveConfession(id);
        } else if ("reject".equals(action)) {
            dao.rejectConfession(id);
        }

        response.sendRedirect("admin");
    }
}