package org.library.WeatherStationObserverPattern.Observable;

import org.library.WeatherStationObserverPattern.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable{

    private List<Observer> observers = new ArrayList<>();
    private String temperature;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        for(Observer observer : observers){
            observer.update(message);
        }
    }

    public void setTemperature(String temperature){
        this.temperature = temperature;
        notifyObserver("Temperature updated: " + temperature);
    }
}
