package com.user.controller;

import com.user.Pojo.UserInfo;
import com.user.dao.UserDao;
import com.user.daoimpl.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserInfo user = new UserInfo();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        UserDao dao = new UserDB(); // using your implementation class
        boolean success = dao.addnewUser(user);

        if (success) {
            req.setAttribute("message", "Signup successful! Please login.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Email already exists or signup failed.");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        }
    }
}