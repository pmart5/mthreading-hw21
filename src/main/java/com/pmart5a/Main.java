package com.pmart5a;

import com.pmart5a.myclasses.CarDealership;

public class Main {

    public static final int NUMBER_OF_TREADS = 5;

    public static void main(String[] args) {
        final CarDealership carDealership = new CarDealership();
        for (int i = 0; i < NUMBER_OF_TREADS; i++) {
            if (i == 0) {
                new Thread(null, carDealership::acceptCars, "Автозавод").start();
            } else {
                new Thread(null, carDealership::sellCars, i + " покупатель").start();
            }
        }
    }
}