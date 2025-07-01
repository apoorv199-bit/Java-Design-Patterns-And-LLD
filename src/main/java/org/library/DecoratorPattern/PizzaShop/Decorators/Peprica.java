package org.library.DecoratorPattern.PizzaShop.Decorators;

import org.library.DecoratorPattern.PizzaShop.BasePizza;

public class Peprica extends ToppingsDecorator{

    private final BasePizza basePizza;

    public Peprica(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 20;
    }
}
