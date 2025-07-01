package org.library.LLD.Tomato.models;

import org.library.LLD.Tomato.strategies.PaymentStrategy;

import java.util.List;

public abstract class Order {
    private static int nextOrderId = 0;
    protected int orderId;
    protected Restaurant restaurant;
    protected User user;
    protected List<MenuItem> items;
    protected PaymentStrategy paymentStrategy;
    protected double total;
    protected String scheduled;

    public Order(){
        this.orderId = ++nextOrderId;
        this.restaurant = null;
        this.user = null;
        this.paymentStrategy = null;
        this.total = 0.0;
        this.scheduled = "";
    }

    public boolean processPayment(){
        if(paymentStrategy != null){
            paymentStrategy.pay(total);
            return true;
        }
        System.out.println("Please choose a payment mode first");
        return false;
    }

    public abstract String getType();

    public int getOrderId() {
        return orderId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
        total = 0.0;
        for(MenuItem item : items){
            total += item.getPrice();
        }
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }
}
