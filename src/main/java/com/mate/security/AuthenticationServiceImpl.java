package com.mate.security;

import com.mate.exception.AuthenticationException;
import com.mate.lib.Inject;
import com.mate.lib.Injector;
import com.mate.lib.Service;
import com.mate.model.Driver;
import com.mate.service.DriverService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private DriverService driverService;

    @Override
    public Driver login(String login, String password) throws AuthenticationException {
        Driver driver = driverService.findByLogin(login).orElseThrow(
                () -> new AuthenticationException("Incorrect password or login"));
        if (driver.getPassword().equals(password)) {
            return driver;
        }
        throw new AuthenticationException("Incorrect password or login");
    }
}
