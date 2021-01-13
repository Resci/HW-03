package com.mate.service;

import com.mate.dao.CarDao;
import com.mate.dao.DriverDao;
import com.mate.lib.Inject;
import com.mate.lib.Service;
import com.mate.model.Car;
import com.mate.model.Driver;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Inject
    CarDao carDao;

    @Inject
    DriverDao driverDao;

    @Override
    public Car create(Car car) {
        return carDao.create(car);
    }

    @Override
    public Car get(Long id) {
        return carDao.get(id).get();
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }

    @Override
    public Car update(Car car) {
        return carDao.update(car);
    }

    @Override
    public boolean delete(Long id) {
        return carDao.delete(id);
    }

    @Override
    public void addDriverToCar(Driver driver, Car car) {
        car.getDrivers().add(driver);
    }

    @Override
    public void removeDriverFromCar(Driver driver, Car car) {
        car.getDrivers().remove(driver);
    }

    @Override
    public List<Car> getAllByDriver(Long driverId) {
        Driver driver = driverDao.get(driverId).get();
        return carDao.getAll()
                .stream()
                .filter(car -> car.getDrivers().contains(driver))
                .collect(Collectors.toList());
    }
}
