package org.library.DecoratorPattern.CoffeeMakingApplication.Decoratos;

import org.library.DecoratorPattern.CoffeeMakingApplication.Coffee;

public class WithMilk extends CoffeeDecorator{

    public WithMilk(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + " with Milk";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 10.0;
    }
}
