package com.mate.security;

import com.mate.exception.AuthenticationException;
import com.mate.model.Driver;

public interface AuthenticationService {
    Driver login(String login, String password) throws AuthenticationException;
}
