package org.library.LLD.Tomato.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restaurant restaurant;
    private List<MenuItem> items = new ArrayList<>();

    public Cart(){
        this.restaurant = null;
    }

    public void addItem(MenuItem item){
        if(this.restaurant == null){
            System.err.println("Cart: Set a restaurant before adding an item.");
            return;
        }
        this.items.add(item);
    }

    public double getTotalCost(){
        double cost = 0.0;
        for(MenuItem item : items){
            cost += item.getPrice();
        }
        return cost;
    }

    public boolean isEmpty(){
        return restaurant == null || items.isEmpty();
    }

    public void clear(){
        this.restaurant = null;
        items.clear();
    }

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant(){
        return this.restaurant;
    }

    public List<MenuItem> getItems(){
        return this.items;
    }
}
