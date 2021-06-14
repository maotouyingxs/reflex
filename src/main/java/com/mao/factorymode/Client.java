package com.mao.factorymode;

public class Client {
    public static void main(String[] args) {
        Car bydCar = CarFactory.createCar("比亚迪");
        Car jiliCar = CarFactory.createCar("吉利");
        bydCar.run();
        jiliCar.run();
    }
}
