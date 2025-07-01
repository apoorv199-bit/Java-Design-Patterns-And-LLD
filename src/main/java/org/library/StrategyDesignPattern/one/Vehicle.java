package org.library.StrategyDesignPattern.one;

import org.library.StrategyDesignPattern.one.strategy.DriveStrategy;

public class Vehicle {
    DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy obj){
        this.driveStrategy = obj;
    }

    public void drive(){
        this.driveStrategy.drive();
    }
}
