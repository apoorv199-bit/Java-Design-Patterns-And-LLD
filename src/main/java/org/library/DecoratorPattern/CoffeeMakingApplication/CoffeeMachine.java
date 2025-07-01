package org.library.DecoratorPattern.CoffeeMakingApplication;

import org.library.DecoratorPattern.CoffeeMakingApplication.Decoratos.WithMilk;
import org.library.DecoratorPattern.CoffeeMakingApplication.Decoratos.WithSugar;

public class CoffeeMachine {
    public static void main(String[] args){
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        coffee = new WithMilk(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        coffee = new WithSugar(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.cost());

        Coffee coffee1 = new WithSugar(new SimpleCoffee());
        System.out.println(coffee1.getDescription() + " $" + coffee1.cost());

    }
}
