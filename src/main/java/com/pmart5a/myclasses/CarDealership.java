package com.pmart5a.myclasses;

import java.util.ArrayList;
import java.util.List;

public class CarDealership {

    public static final int TIME_TO_SHOP = 1000;
    public static final int CAR_SUPPLY_PLAN = 11;
    private static final List<Car> cars = new ArrayList<>(CAR_SUPPLY_PLAN);
    private final CarFactory carFactory = new CarFactory();
    private boolean stopSales = false;

    public synchronized void acceptCar() {
        try {
            for (int i = 0; i < CAR_SUPPLY_PLAN; i++) {
                System.out.printf("%s: собираю автомобиль.\n", Thread.currentThread().getName());
                getCars().add(carFactory.assembleTheCar());
                System.out.printf("%s: выпущен 1 автомобиль.\n", Thread.currentThread().getName());
                if (i == CAR_SUPPLY_PLAN - 1) {
                    stopSales = true;
                    notifyAll();
                    break;
                } else {
                    notify();
                    wait();
                }
            }
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized List<Car> sellCar() {
        List<Car> purchasedCars = new ArrayList<>();
        while (!stopSales) {
            try {
                System.out.printf("%s зашёл в автосалон.\n", Thread.currentThread().getName());
                if (getCars().isEmpty()) {
                    System.out.println("Машин нет!");
                } else {
                    Thread.sleep(TIME_TO_SHOP);
                    Car car = getCars().remove(0);
                    System.out.printf("%s уехал на новом авто марки '%s' модель '%s %d'.\n",
                            Thread.currentThread().getName(), car.getCarBrand(), car.getCarModel(),
                            car.getEnginePower());
                    purchasedCars.add(car);
                    notifyAll();
                }
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s, всего куплено автомобилей: %d.\n", Thread.currentThread().getName(), purchasedCars.size());
        Thread.currentThread().interrupt();
        return purchasedCars;
    }

    static List<Car> getCars() {
        return cars;
    }
}