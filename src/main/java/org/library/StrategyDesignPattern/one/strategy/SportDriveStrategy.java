package org.library.StrategyDesignPattern.one.strategy;

public class SportDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Sports Drive Strategy.");
    }
}
