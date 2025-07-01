package org.library.LLD.FitnessClassBookingSystem.utils;

import java.time.LocalDateTime;

public class ValidationUtils {

    public static boolean isValidEmail(String email){
        return email != null && email.contains("@") && email.contains(".");
    }

    public static boolean isValidPassword(String password){
        return password != null && password.length() >= 6;
    }

    public static boolean isValidName(String name){
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidCapacity(int capacity){
        return capacity > 0 && capacity <= 100;
    }

    public static boolean isValidScheduledTime(LocalDateTime scheduledTime){
        return scheduledTime != null && scheduledTime.isAfter(LocalDateTime.now());
    }
}
