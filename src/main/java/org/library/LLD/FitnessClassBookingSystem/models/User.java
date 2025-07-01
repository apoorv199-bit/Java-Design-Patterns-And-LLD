package org.library.LLD.FitnessClassBookingSystem.models;

import org.library.LLD.FitnessClassBookingSystem.enums.UserTier;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String userId;
    private String name;
    private String email;
    private String password;
    private UserTier tier;
    private int currentBookings;
    private Set<String> bookedClasses;

    public User(String userId, String name, String email, String password, UserTier tier) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.tier = tier;
        this.currentBookings = 0;
        this.bookedClasses = new HashSet<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserTier getTier() {
        return tier;
    }

    public int getCurrentBookings() {
        return currentBookings;
    }

    public Set<String> getBookedClasses() {
        return bookedClasses;
    }

    public void setTier(UserTier tier){
        this.tier = tier;
    }

    public boolean canBook(){
        return currentBookings < tier.getBookingLimit();
    }

    public void incrementBookings(){
        currentBookings++;
    }

    public void decrementBookings(){
        if(currentBookings > 0){
            currentBookings--;
        }
    }

    public void addBookedClass(String classId){
        bookedClasses.add(classId);
    }

    public void removeBookedClass(String classId){
        bookedClasses.remove(classId);
    }
}
