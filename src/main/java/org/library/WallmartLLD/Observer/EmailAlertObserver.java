package org.library.WallmartLLD.Observer;

import org.library.WallmartLLD.Observable.StockObservable;

public class EmailAlertObserver implements NotificationAlertObserver{

    StockObservable observable;
    String emailId;

    public EmailAlertObserver(StockObservable observable, String emailId){
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMail(emailId, "Product is in stock, hurry up!");
    }

    private void sendMail(String emailId, String msg){
        System.out.println("Email sent to " + emailId + "(" + msg + ")");
    }
}
