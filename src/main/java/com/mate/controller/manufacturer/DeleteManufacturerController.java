package com.mate.controller.manufacturer;

import com.mate.lib.Injector;
import com.mate.service.ManufacturerService;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteManufacturerController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("com.mate");
    private final ManufacturerService manufacturerService = (ManufacturerService) injector
            .getInstance(ManufacturerService.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        manufacturerService.delete(Long.parseLong(req.getParameter("delete")));
        resp.sendRedirect("/manufacturers/all");
    }
}
