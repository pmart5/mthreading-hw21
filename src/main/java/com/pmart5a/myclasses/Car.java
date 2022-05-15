package com.pmart5a.myclasses;

import java.util.Random;

public class Car {

    private static final String[] carModels = {"Тарантас", "Вжик", "Вездеход"};
    private static final int[] enginePowers = {90, 370, 700};

    private String carBrand = "ЖМИ";
    private String carModel;
    private int enginePower;

    public Car() {
        int modelNumber = getCarModelRandom();
        carModel = carModels[modelNumber];
        enginePower = enginePowers[modelNumber];
    }

    public Car(String carBrand, String carModel, int enginePower) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.enginePower = enginePower;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    private int getCarModelRandom(){
        return new Random().nextInt(carModels.length);
    }

    @Override
    public String toString() {
        return String.format("Автомобиль: марка - %s, модель - %s, мощность двигателя - %d л.с.\n", carBrand, carModel,
                enginePower);
    }
}