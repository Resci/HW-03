package com.mate.db;

import com.mate.model.Car;
import com.mate.model.Driver;
import com.mate.model.Manufacturer;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<Manufacturer> manufacturers = new ArrayList<>();
    public static final List<Car> cars = new ArrayList<>();
    public static final List<Driver> drivers = new ArrayList<>();
    private static Long manufacturerId = 0L;
    private static Long carId = 0L;
    private static Long driverId = 0L;

    public static void addManufacturer(Manufacturer manufacturer) {
        manufacturerId++;
        manufacturer.setId(manufacturerId);
        manufacturers.add(manufacturer);
    }

    public static void addCar(Car car) {
        carId++;
        car.setId(carId);
        cars.add(car);
    }

    public static void addDriver(Driver driver) {
        driverId++;
        driver.setId(driverId);
        drivers.add(driver);
    }
}
