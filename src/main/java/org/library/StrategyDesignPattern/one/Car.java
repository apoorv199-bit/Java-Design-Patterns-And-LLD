package org.library.StrategyDesignPattern.one;

import org.library.StrategyDesignPattern.one.strategy.NormalDriveStrategy;

public class Car extends Vehicle {
    Car(){
        super(new NormalDriveStrategy());
    }
}
