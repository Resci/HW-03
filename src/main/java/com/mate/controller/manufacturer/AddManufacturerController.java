package com.mate.controller.manufacturer;

import com.mate.lib.Injector;
import com.mate.model.Manufacturer;
import com.mate.service.ManufacturerService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddManufacturerController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("com.mate");
    private final ManufacturerService manufacturerService = (ManufacturerService) injector
            .getInstance(ManufacturerService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/manufacturers/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        manufacturerService.create(new Manufacturer(
                req.getParameter("name"),
                req.getParameter("country")));
        resp.sendRedirect("/manufacturers/add");
    }
}
