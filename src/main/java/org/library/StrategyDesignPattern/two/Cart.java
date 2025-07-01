package org.library.StrategyDesignPattern.two;

import org.library.StrategyDesignPattern.two.strategy.DiscountStrategy;

public class Cart {
    private DiscountStrategy discountStrategy;
    private double totalAmount;

    public Cart(double totalAmount){
        this.totalAmount = totalAmount;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }

    public double calculateFinalAmount(){
        return totalAmount - discountStrategy.calculateDiscount(totalAmount);
    }
}
