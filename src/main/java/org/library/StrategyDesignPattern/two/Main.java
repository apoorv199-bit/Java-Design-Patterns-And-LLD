package org.library.StrategyDesignPattern.two;

import org.library.StrategyDesignPattern.two.strategy.FixedAmountDiscount;
import org.library.StrategyDesignPattern.two.strategy.PercentageDiscount;

public class Main {
    public static void main(String[] args){
        Cart cart = new Cart(2000);
        double discountPercentage = 10;
        cart.setDiscountStrategy(new PercentageDiscount(discountPercentage));
        System.out.println("Total amount to pay after " + discountPercentage + "% discount is " + cart.calculateFinalAmount());

        double fixedDiscount = 350;
        cart.setDiscountStrategy(new FixedAmountDiscount(fixedDiscount));
        System.out.println("Total amount to pay after a discount of " + fixedDiscount + "Rs is " + cart.calculateFinalAmount());
    }
}
