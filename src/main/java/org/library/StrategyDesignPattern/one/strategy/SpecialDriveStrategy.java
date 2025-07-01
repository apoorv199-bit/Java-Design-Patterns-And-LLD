package org.library.StrategyDesignPattern.one.strategy;

public class SpecialDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Special Drive Strategy.");
    }
}
