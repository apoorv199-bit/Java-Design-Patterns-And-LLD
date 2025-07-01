package org.library.DecoratorPattern.CoffeeMakingApplication.Decoratos;

import org.library.DecoratorPattern.CoffeeMakingApplication.Coffee;

public class WithSugar extends CoffeeDecorator{

    public WithSugar(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + " with Sugar";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 5.0;
    }
}
