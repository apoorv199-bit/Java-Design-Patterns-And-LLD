package org.library.LLD.Tomato.managers;

import org.library.LLD.Tomato.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private static OrderManager instance = null;
    private List<Order> orders = new ArrayList<>();

    private OrderManager(){

    }

    public static OrderManager getInstance(){
        if(instance == null){
            instance = new OrderManager();
        }
        return instance;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void listOrder(){
        System.out.println("\n--- All Orders ---");
        for(Order order : orders){
            System.out.println(order.getType() + " order for " + order.getUser().getName()
                    + " | Total: ₹" + order.getTotal()
                    + " | At: " + order.getScheduled());
        }
    }
}
