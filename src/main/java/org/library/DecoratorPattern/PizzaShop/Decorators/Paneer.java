package org.library.DecoratorPattern.PizzaShop.Decorators;

import org.library.DecoratorPattern.PizzaShop.BasePizza;

public class Paneer extends ToppingsDecorator{

    private BasePizza basePizza;

    public Paneer(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 50;
    }
}
