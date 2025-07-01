package org.library.DecoratorPattern.CoffeeMakingApplication.Decoratos;

import org.library.DecoratorPattern.CoffeeMakingApplication.Coffee;

public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee){
        this.decoratedCoffee = coffee;
    }
}
