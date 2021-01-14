package com.mate;

import com.mate.lib.Injector;
import com.mate.model.Car;
import com.mate.model.Driver;
import com.mate.model.Manufacturer;
import com.mate.service.CarService;
import com.mate.service.DriverService;
import com.mate.service.ManufacturerService;
import java.util.ArrayList;

public class Application {
    private static Injector injector = Injector.getInstance("com.mate");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);

        Manufacturer firstManufacturer = new Manufacturer("Tesla", "USA");
        Manufacturer secondManufacturer = new Manufacturer("BMW", "Germany");
        Manufacturer thirdManufacturer = new Manufacturer("Toyota", "Japan");

        manufacturerService.create(firstManufacturer);
        manufacturerService.create(secondManufacturer);
        manufacturerService.create(thirdManufacturer);

        System.out.println(manufacturerService.getAll());
        Manufacturer tempManufacturer = manufacturerService.get(1L);
        System.out.println(tempManufacturer);
        tempManufacturer.setName("Hyundai");
        tempManufacturer.setCountry("South Korea");
        manufacturerService.update(tempManufacturer);
        System.out.println(manufacturerService.get(1L));
        manufacturerService.delete(2L);
        System.out.println(manufacturerService.getAll());

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        Driver firstDriver = new Driver("Joshua Bloch", "62346");
        Driver secondDriver = new Driver("Bruce Eckel", "23663");
        Driver thirdDriver = new Driver("Linus Torvalds", "46837");

        driverService.create(firstDriver);
        driverService.create(secondDriver);
        driverService.create(thirdDriver);

        System.out.println(driverService.getAll());
        Driver tempDriver = driverService.get(1L);
        System.out.println(tempDriver);
        tempDriver.setLicenceNumber("55555");
        driverService.update(tempDriver);
        System.out.println(driverService.get(1L));

        CarService carService = (CarService) injector
                .getInstance(CarService.class);

        Car firstCar = new Car("Model X", firstManufacturer);
        Car secondCar = new Car("i3", secondManufacturer);
        Car thirdCar = new Car("Camry", thirdManufacturer);

        carService.create(firstCar);
        carService.create(secondCar);
        carService.create(thirdCar);

        System.out.println(carService.getAll());

        carService
                .getAll()
                .forEach(car -> car.setDrivers(new ArrayList<>(driverService.getAll())));

        System.out.println(carService.getAll());
        Car tempCar = carService.get(3L);
        System.out.println(tempCar);
        carService.removeDriverFromCar(tempDriver, tempCar);
        carService.update(tempCar);
        System.out.println(carService.get(3L));
        System.out.println(carService.getAllByDriver(tempDriver.getId()));
        carService.addDriverToCar(tempDriver, tempCar);
        carService.update(tempCar);
        System.out.println(carService.getAllByDriver(tempDriver.getId()));
    }
}
