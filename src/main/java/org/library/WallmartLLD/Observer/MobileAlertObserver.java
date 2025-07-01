package org.library.WallmartLLD.Observer;

import org.library.WallmartLLD.Observable.StockObservable;

public class MobileAlertObserver implements NotificationAlertObserver{

    StockObservable observable;
    String username;

    public MobileAlertObserver(StockObservable observable, String username){
        this.observable = observable;
        this.username = username;
    }

    @Override
    public void update() {
        System.out.println("Hi " + username + " Product is in stock, hurry up!");
    }
}
