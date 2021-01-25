package com.mate.web.filter;

import com.mate.lib.Injector;
import com.mate.service.DriverService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements Filter {
    private static final String DRIVER_ID = "driver_id";
    private static final Injector injector = Injector.getInstance("com.mate");
    private final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getServletPath();
        if (url.equals("/drivers/add") || url.equals("/drivers/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        Long driverId = (Long) request.getSession().getAttribute(DRIVER_ID);
        if (driverId == null || driverService.get(driverId) == null) {
            response.sendRedirect("/drivers/login");
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
