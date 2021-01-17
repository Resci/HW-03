package com.mate.dao.listimpl;

import com.mate.dao.CarDao;
import com.mate.db.Storage;
import com.mate.model.Car;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarDaoImpl implements CarDao {
    @Override
    public Car create(Car car) {
        Storage.addCar(car);
        return car;
    }

    @Override
    public Optional<Car> get(Long id) {
        return Storage.cars.stream()
                .filter(x -> Objects.equals(x.getId(),id))
                .findFirst();
    }

    @Override
    public List<Car> getAll() {
        return Storage.cars;
    }

    @Override
    public Car update(Car car) {
        Car old = get(car.getId()).get();
        Storage.cars.set(Storage.cars.indexOf(old), car);
        return old;
    }

    @Override
    public boolean delete(Long id) {
        return Storage.cars.removeIf(x -> x.getId().equals(id));
    }

    public List<Car> getAllByDriver(Long driverId) {
        return Storage.cars.stream()
                .filter(car -> car.getDrivers()
                        .stream()
                        .anyMatch(driver -> driver.getId().equals(driverId)))
                .collect(Collectors.toList());
    }

}
