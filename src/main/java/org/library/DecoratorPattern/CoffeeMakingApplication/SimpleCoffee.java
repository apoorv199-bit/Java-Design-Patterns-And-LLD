package org.library.DecoratorPattern.CoffeeMakingApplication;

public class SimpleCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 20.0;
    }
}
