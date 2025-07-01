package org.library.LLD.Tomato.models;

public class User {
    private static int nextUserId = 0;
    private int userId;
    private String name;
    private String address;;
    private Cart cart;

    public User(String name, String address){
        this.userId = ++nextUserId;
        this.name = name;
        this.address = address;
        this.cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

}
