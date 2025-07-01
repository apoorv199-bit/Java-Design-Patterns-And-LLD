package org.library.StrategyDesignPattern.one;

import org.library.StrategyDesignPattern.one.strategy.SpecialDriveStrategy;

public class SpecialVehicle extends Vehicle {
    SpecialVehicle(){
        super(new SpecialDriveStrategy());
    }
}
