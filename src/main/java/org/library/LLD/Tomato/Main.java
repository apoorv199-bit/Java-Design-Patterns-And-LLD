package org.library.LLD.Tomato;

import org.library.LLD.Tomato.managers.OrderManager;
import org.library.LLD.Tomato.models.Order;
import org.library.LLD.Tomato.models.Restaurant;
import org.library.LLD.Tomato.models.User;
import org.library.LLD.Tomato.strategies.UpiPaymentStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args){
        TomatoApp tomato = new TomatoApp();

        User user = new User("Apoorv", "Bengaluru");
        System.out.println("User: " + user.getName() + " is active.");

        List<Restaurant> restaurantList = tomato.searchRestaurants("Delhi");

        if(restaurantList.isEmpty()){
            System.out.println("No restaurants found!");
            return;
        }

        System.out.println("Found Restaurants:");
        for(Restaurant restaurant : restaurantList){
            System.out.println(" - " + restaurant.getName());
        }

        tomato.selectRestaurant(user, restaurantList.get(0));
        System.out.println("Selected restaurant: " + restaurantList.get(0).getName());

        tomato.addToCart(user, "P1");
        tomato.addToCart(user, "P2");

        tomato.printUserCart(user);

        Order order = tomato.checkoutNow(user, "Delivery", new UpiPaymentStrategy("6394917636"));

        tomato.payForOrder(user, order);

        OrderManager.getInstance().listOrder();

    }
}
