package com.pmart5a;

import com.pmart5a.myclasses.CarDealership;

public class Main {

    public static void main(String[] args) {
        final CarDealership carDealership = new CarDealership();
        String[] nameThreads = {"1 покупатель", "2 покупатель", "3 покупатель", "4 покупатель", "Автозавод"};
        for (int i = 0; i < nameThreads.length; i++) {
            if (i < nameThreads.length - 1) {
                new Thread(null, carDealership::sellCar, nameThreads[i]).start();
            } else {
                new Thread(null, carDealership::acceptCar, nameThreads[i]).start();
            }
        }
    }
}