package org.library.DecoratorPattern.PizzaShop.Decorators;

import org.library.DecoratorPattern.PizzaShop.BasePizza;

public class ExtraCheese extends ToppingsDecorator{
    private BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 30;
    }
}
