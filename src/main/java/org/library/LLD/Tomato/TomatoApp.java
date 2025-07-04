package org.library.LLD.Tomato;

import org.library.LLD.Tomato.factories.NowOrderFactory;
import org.library.LLD.Tomato.factories.OrderFactory;
import org.library.LLD.Tomato.factories.ScheduledOrderFactory;
import org.library.LLD.Tomato.managers.OrderManager;
import org.library.LLD.Tomato.managers.RestaurantManager;
import org.library.LLD.Tomato.models.*;
import org.library.LLD.Tomato.services.NotificationService;
import org.library.LLD.Tomato.strategies.PaymentStrategy;

import java.util.List;

public class TomatoApp {

    public TomatoApp(){
        initializeRestaurants();
    }

    private void initializeRestaurants(){
        Restaurant restaurant1 = new Restaurant("Bikaner", "Delhi");
        restaurant1.addMenuItem(new MenuItem("P1", "Chole Bhature", 120));
        restaurant1.addMenuItem(new MenuItem("P2", "Samosa", 15));

        Restaurant restaurant2 = new Restaurant("Haldiram", "Kolkata");
        restaurant2.addMenuItem(new MenuItem("P1", "Raj Kachori", 80));
        restaurant2.addMenuItem(new MenuItem("P2", "Pav Bhaji", 100));
        restaurant2.addMenuItem(new MenuItem("P3", "Dhokla", 50));

        Restaurant restaurant3 = new Restaurant("Saravana Bhavan", "Chennai");
        restaurant3.addMenuItem(new MenuItem("P1", "Masala Dosa", 90));
        restaurant3.addMenuItem(new MenuItem("P2", "Idli Vada", 60));
        restaurant3.addMenuItem(new MenuItem("P3", "Filter Coffee", 30));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        restaurantManager.addRestaurant(restaurant3);
    }

    public List<Restaurant> searchRestaurants(String location){
        return RestaurantManager.getInstance().searchByLocation(location);
    }

    public void selectRestaurant(User user, Restaurant restaurant){
        Cart cart = user.getCart();
        cart.setRestaurant(restaurant);
    }

    public void addToCart(User user, String itemCode){
        Restaurant restaurant = user.getCart().getRestaurant();
        if(restaurant == null){
            System.out.println("Please select a restaurant first.");
            return;
        }
        for(MenuItem item : restaurant.getMenu()){
            if(item.getCode().equals(itemCode)){
                user.getCart().addItem(item);
                break;
            }
        }
    }

    public Order checkoutNow(User user, String orderType, PaymentStrategy paymentStrategy){
        return checkOut(user, orderType, paymentStrategy, new NowOrderFactory());
    }

    public Order checkoutScheduled(User user, String orderType, PaymentStrategy paymentStrategy, String scheduledTime){
        return checkOut(user, orderType, paymentStrategy, new ScheduledOrderFactory(scheduledTime));
    }

    public Order checkOut(User user, String orderType, PaymentStrategy paymentStrategy, OrderFactory orderFactory){
        if(user.getCart().isEmpty()){
            return null;
        }
        Cart userCart = user.getCart();
        Restaurant restaurant = userCart.getRestaurant();
        List<MenuItem> itemsOrdered = userCart.getItems();
        double totalCost = userCart.getTotalCost();

        Order order = orderFactory.createOrder(user, userCart, restaurant, itemsOrdered, paymentStrategy, totalCost, orderType);
        OrderManager.getInstance().addOrder(order);
        return order;
    }

    public void payForOrder(User user, Order order){
        boolean isPaymentSuccess = order.processPayment();
        if(isPaymentSuccess){
            NotificationService.notify(order);
            user.getCart().clear();
        }
    }

    public void printUserCart(User user){
        System.out.println("Items in cart:");
        System.out.println("------------------------------------");
        for (MenuItem item : user.getCart().getItems()) {
            System.out.println(item.getCode() + " : " + item.getName() + " : ₹" + item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : ₹" + user.getCart().getTotalCost());
    }

}
