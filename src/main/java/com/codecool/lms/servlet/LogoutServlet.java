package com.codecool.lms.servlet;

import com.codecool.lms.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl.getUserService().setCurrentUser(null);
        req.setAttribute("message", "Now you can login again!");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
