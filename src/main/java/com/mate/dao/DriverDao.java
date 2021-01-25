package com.mate.dao;

import com.mate.model.Driver;

import java.util.Optional;

public interface DriverDao extends GenericDao<Driver, Long> {
    Optional<Driver> findByLogin(String login);
}
