package org.library.StrategyDesignPattern.one;

import org.library.StrategyDesignPattern.one.strategy.SportDriveStrategy;

public class SportsBike extends Vehicle {
    SportsBike(){
        super(new SportDriveStrategy());
    }
}
