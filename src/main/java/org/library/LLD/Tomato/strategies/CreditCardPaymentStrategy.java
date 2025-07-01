package org.library.LLD.Tomato.strategies;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    private String cardNumber;

    public CreditCardPaymentStrategy(String number){
        this.cardNumber = number;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card (" + cardNumber + ")");
    }
}
