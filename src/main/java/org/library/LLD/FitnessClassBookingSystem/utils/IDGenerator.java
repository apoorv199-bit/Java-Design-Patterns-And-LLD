package org.library.LLD.FitnessClassBookingSystem.utils;

public class IDGenerator {

    public static String generateUserId(){
        return "USER_" + System.currentTimeMillis() + "_" + (int)(Math.random() * 1000);
    }

    public static String generateClassId(){
        return "CLASS_" + System.currentTimeMillis() + "_" + (int)(Math.random() * 1000);
    }

    public static String generateBookingId(){
        return "BOOKING_" + System.currentTimeMillis() + "_" + (int)(Math.random() * 1000);
    }
}
