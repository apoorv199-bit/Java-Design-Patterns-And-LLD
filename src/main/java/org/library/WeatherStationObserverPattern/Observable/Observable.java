package org.library.WeatherStationObserverPattern.Observable;

import org.library.WeatherStationObserverPattern.Observer.Observer;

public interface Observable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(String message);
}
