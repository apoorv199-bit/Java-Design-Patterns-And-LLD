package org.library.StrategyDesignPattern.one;

public class Main {
    public static void main(String[] args){
        Vehicle bike = new SportsBike();
        bike.drive();

        Vehicle car = new Car();
        car.drive();

        Vehicle bmw = new SpecialVehicle();
        bmw.drive();
    }
}
