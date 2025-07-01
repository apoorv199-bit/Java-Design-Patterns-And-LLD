package org.library.WeatherStationObserverPattern.Observer;

public class DisplayDevice implements Observer{
    private String name;

    public DisplayDevice(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + ": " + message);
    }
}
