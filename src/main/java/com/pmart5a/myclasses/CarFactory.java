package com.pmart5a.myclasses;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static final int CAR_RELEASE_PLAN = 11;
    public static final int TIME_ASSEMBLY_CAR = 3000;
    public static final int TIME_TO_SHOP = 1000;
    private boolean stopSales = false;
    private final CarDealership carDealership;

    public CarFactory(CarDealership carDealership) {
        this.carDealership = carDealership;
    }

    public synchronized void receiveCar() {
        try {
            for (int i = 0; i < CAR_RELEASE_PLAN; i++) {
                System.out.printf("%s: собираю автомобиль.\n", Thread.currentThread().getName());
                Thread.sleep(TIME_ASSEMBLY_CAR);
                CarDealership.getCars().add(new Car());
                System.out.printf("%s: выпущен 1 автомобиль.\n", Thread.currentThread().getName());
                if (i == CAR_RELEASE_PLAN - 1) {
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

    public synchronized List<Car> sellCars() {
        List<Car> purchasedCars = new ArrayList<>(CAR_RELEASE_PLAN);
        while (!stopSales) {
            try {
                System.out.printf("%s зашёл в автосалон.\n", Thread.currentThread().getName());
                if (CarDealership.getCars().size() == 0) {
                    System.out.println("Машин нет!");
                } else {
                    Thread.sleep(TIME_TO_SHOP);
                    Car car = CarDealership.getCars().remove(0);
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
}