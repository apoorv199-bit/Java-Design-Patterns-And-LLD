package org.library.WeatherStationObserverPattern;

import org.library.WeatherStationObserverPattern.Observable.WeatherStation;
import org.library.WeatherStationObserverPattern.Observer.DisplayDevice;

public class Main {
    public static void main(String[] args){
        WeatherStation weatherStation = new WeatherStation();

        weatherStation.registerObserver(new DisplayDevice("Display 1"));
        weatherStation.registerObserver(new DisplayDevice("Display 2"));
        weatherStation.registerObserver(new DisplayDevice("TV"));

        weatherStation.setTemperature("45 degree C");
    }
}
