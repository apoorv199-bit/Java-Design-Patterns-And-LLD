package org.library.LLD.FitnessClassBookingSystem.exceptions;

public class BookingLimitExceededException extends RuntimeException{
    public BookingLimitExceededException(String message){
        super(message);
    }
}
