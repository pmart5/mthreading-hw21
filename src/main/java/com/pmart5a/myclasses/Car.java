package com.pmart5a.myclasses;

public class Car {

    private String carBrand;
    private String carModel;
    private int enginePower;

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

    @Override
    public String toString() {
        return String.format("Автомобиль: марка - %s, модель - %s, мощность двигателя - %d л.с.\n", carBrand, carModel,
                enginePower);
    }
}