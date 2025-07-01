package org.library.DecoratorPattern.PizzaShop;

import org.library.DecoratorPattern.PizzaShop.Decorators.ExtraCheese;
import org.library.DecoratorPattern.PizzaShop.Decorators.Paneer;
import org.library.DecoratorPattern.PizzaShop.Decorators.Peprica;

public class Store {

    public static void main(String[] args){
        BasePizza pizza = new ExtraCheese(new Margherita());
        System.out.println(pizza.cost());

        BasePizza pizza1 = new Paneer(new ExtraCheese(new Margherita()));
        System.out.println("Your Margherita Pizza with Paneer and Extra Cheese is ready. Please Pay " + pizza1.cost() + "Rs");

        BasePizza pizza2 = new Peprica(new Paneer(new ExtraCheese(new Farmhouse())));
        System.out.println("Your Farmhouse Pizza with Peprica, Paneer and Extra Cheese is ready. Please Pay " + pizza2.cost() + "Rs");

    }
}
