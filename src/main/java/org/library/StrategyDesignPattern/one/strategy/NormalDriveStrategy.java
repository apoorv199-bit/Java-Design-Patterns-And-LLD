package org.library.StrategyDesignPattern.one.strategy;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Normal Drive Strategy.");
    }
}
