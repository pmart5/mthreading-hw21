package com.pmart5a.myclasses;

import java.util.Random;

public class CarFactory {

    public static final int TIME_ASSEMBLY_CAR = 3000;
    private static final String carBrand = "ЖМИ";
    private static final String[] carModels = {"Тарантас", "Вжик", "Вездеход"};
    private static final int[] enginePowers = {90, 370, 700};

    public Car assembleTheCar() {
        int modelNumber = getCarModelRandom();
        String carModel = carModels[modelNumber];
        int enginePower = enginePowers[modelNumber];
        try {
            Thread.sleep(CarFactory.TIME_ASSEMBLY_CAR);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Car(carBrand, carModel, enginePower);
    }

    private int getCarModelRandom() {
        return new Random().nextInt(carModels.length);
    }
}