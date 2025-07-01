package org.library.LLD.Tomato.managers;

import org.library.LLD.Tomato.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {
    private static RestaurantManager instance = null;
    private List<Restaurant> restaurants = new ArrayList<>();

    private RestaurantManager(){

    }

    public static RestaurantManager getInstance(){
        if(instance == null){
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant){
        this.restaurants.add(restaurant);
    }

    public List<Restaurant> searchByLocation(String location){
        List<Restaurant> res = new ArrayList<>();
        location = location.toLowerCase();
        for(Restaurant restaurant: restaurants){
            if(restaurant.getLocation().toLowerCase().equals(location)){
                res.add(restaurant);
            }
        }
        return res;
    }

}
