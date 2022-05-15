package com.pmart5a.myclasses;

import java.util.ArrayList;
import java.util.List;

public class CarDealership {
    CarFactory carFactory = new CarFactory(this);
    static List<Car> cars = new ArrayList<>(CarFactory.CAR_RELEASE_PLAN);

    public List<Car> sellCar() {
        return carFactory.sellCars();
    }

    public void acceptCar() {
        carFactory.receiveCar();
    }

    static List<Car> getCars() {
        return cars;
    }
}