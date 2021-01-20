package com.mate.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        if (req.getParameter("All drivers") != null) {
            resp.sendRedirect("/drivers/all");
        }
        if (req.getParameter("All cars") != null) {
            resp.sendRedirect("/cars/all");
        }
        if (req.getParameter("All manufacturers") != null) {
            resp.sendRedirect("/manufacturers/all");
        }
        if (req.getParameter("Add driver") != null) {
            resp.sendRedirect("/drivers/add");
        }
        if (req.getParameter("Add manufacturer") != null) {
            resp.sendRedirect("/manufacturers/add");
        }
        if (req.getParameter("Add car") != null) {
            resp.sendRedirect("/cars/add");
        }
        if (req.getParameter("Add driver to car") != null) {
            resp.sendRedirect("/cars/add_driver_to_car");
        }
    }
}
