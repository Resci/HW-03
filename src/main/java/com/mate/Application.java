package com.mate;

import com.mate.lib.Injector;
import com.mate.model.Car;
import com.mate.model.Driver;
import com.mate.model.Manufacturer;
import com.mate.service.CarService;
import com.mate.service.DriverService;
import com.mate.service.ManufacturerService;
import java.util.List;

public class Application {
    private static Injector injector = Injector.getInstance("com.mate");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);

        Manufacturer firstManufacturer = new Manufacturer("Tesla", "USA");
        Manufacturer secondManufacturer = new Manufacturer("BMW", "Germany");
        Manufacturer thirdManufacturer = new Manufacturer("Toyota", "Japan");

        firstManufacturer = manufacturerService.create(firstManufacturer);
        secondManufacturer = manufacturerService.create(secondManufacturer);
        thirdManufacturer = manufacturerService.create(thirdManufacturer);

        System.out.println(manufacturerService.getAll());
        Manufacturer tempManufacturer = manufacturerService.get(firstManufacturer.getId());
        System.out.println(tempManufacturer);
        tempManufacturer.setName("Hyundai");
        tempManufacturer.setCountry("South Korea");
        manufacturerService.update(tempManufacturer);
        System.out.println(manufacturerService.get(firstManufacturer.getId()));
        manufacturerService.delete(secondManufacturer.getId());
        System.out.println(manufacturerService.getAll());

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        Driver firstDriver = new Driver("Joshua Bloch", "62346");
        Driver secondDriver = new Driver("Bruce Eckel", "23663");
        Driver thirdDriver = new Driver("Linus Torvalds", "46837");

        firstDriver = driverService.create(firstDriver);
        secondDriver = driverService.create(secondDriver);
        thirdDriver = driverService.create(thirdDriver);

        System.out.println(driverService.getAll());
        Driver tempDriver = driverService.get(firstDriver.getId());
        System.out.println(tempDriver);
        tempDriver.setLicenceNumber("55555");
        driverService.update(tempDriver);
        System.out.println(driverService.get(firstDriver.getId()));

        Car firstCar = new Car("Model X", firstManufacturer);
        Car secondCar = new Car("i3", secondManufacturer);
        Car thirdCar = new Car("Camry", thirdManufacturer);

        firstCar.setDrivers(List.of(firstDriver, secondDriver));
        secondCar.setDrivers(List.of(secondDriver, thirdDriver));
        thirdCar.setDrivers(List.of(firstDriver, thirdDriver));

        CarService carService = (CarService) injector
                .getInstance(CarService.class);

        carService.create(firstCar);
        carService.create(secondCar);
        carService.create(thirdCar);

        System.out.println(carService.getAll());
        Car tempCar = carService.get(thirdCar.getId());
        System.out.println(tempCar);
        carService.removeDriverFromCar(thirdDriver, tempCar);
        carService.update(tempCar);
        System.out.println(carService.get(thirdCar.getId()));
        System.out.println(carService.getAllByDriver(tempDriver.getId()));

        tempCar = carService.get(secondCar.getId());
        carService.addDriverToCar(tempDriver, tempCar);
        carService.update(tempCar);
        System.out.println(carService.getAllByDriver(tempDriver.getId()));

        driverService.delete(thirdDriver.getId());
    }
}

