package org.library.WallmartLLD;

import org.library.WallmartLLD.Observable.IphoneObservable;
import org.library.WallmartLLD.Observable.StockObservable;
import org.library.WallmartLLD.Observer.EmailAlertObserver;
import org.library.WallmartLLD.Observer.MobileAlertObserver;
import org.library.WallmartLLD.Observer.NotificationAlertObserver;

public class Store {

    public static void main(String[] args){
        StockObservable iphoneObservable = new IphoneObservable();

        NotificationAlertObserver observer1 = new EmailAlertObserver(iphoneObservable, "apoorv@gmail.com");
        NotificationAlertObserver observer2 = new EmailAlertObserver(iphoneObservable, "harshita@gmail.com");
        NotificationAlertObserver observer3 = new MobileAlertObserver(iphoneObservable, "Chirag");

        iphoneObservable.add(observer1);
        iphoneObservable.add(observer2);
        iphoneObservable.add(observer3);

        iphoneObservable.setStockCount(10);
    }


}
