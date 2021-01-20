package com.mate.controller.car;

import com.mate.lib.Injector;
import com.mate.service.CarService;
import com.mate.service.DriverService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddDriverToCarController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("com.mate");
    private final CarService carService = (CarService) injector
            .getInstance(CarService.class);
    private final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/cars/add_driver_to_car.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        carService.addDriverToCar(
                driverService.get(Long.parseLong(req.getParameter("driver_id"))),
                carService.get(Long.parseLong(req.getParameter("car_id"))));
        req.getRequestDispatcher("/WEB-INF/views/cars/add_driver_to_car.jsp").forward(req, resp);
    }
}
