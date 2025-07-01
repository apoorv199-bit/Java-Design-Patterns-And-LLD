package org.library.WallmartLLD.Observable;

import org.library.WallmartLLD.Observer.NotificationAlertObserver;

public interface StockObservable {
    void add(NotificationAlertObserver observer);
    void remove(NotificationAlertObserver observer);
    void notifySubscriber();
    void setStockCount(int newStockAdded);
    int getStockCount();
}
