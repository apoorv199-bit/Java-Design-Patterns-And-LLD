package org.library.StrategyDesignPattern.two.strategy;

public class FixedAmountDiscount implements DiscountStrategy{

    private final double discountAmount;

    public FixedAmountDiscount(double discountAmount){
        this.discountAmount = discountAmount;
    }

    @Override
    public double calculateDiscount(double totalAmount) {
        return discountAmount;
    }
}
