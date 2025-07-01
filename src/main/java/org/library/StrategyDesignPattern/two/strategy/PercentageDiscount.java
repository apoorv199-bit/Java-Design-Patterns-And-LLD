package org.library.StrategyDesignPattern.two.strategy;

public class PercentageDiscount implements DiscountStrategy{

    private final double discountPercentage;

    public PercentageDiscount(double discountPercentage){
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculateDiscount(double totalAmount) {
        return totalAmount * (discountPercentage / 100);
    }
}
