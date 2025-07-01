package org.library.LLD.FitnessClassBookingSystem.dto;

import org.library.LLD.FitnessClassBookingSystem.models.Booking;

public class BookingResult {
    private boolean success;
    private String message;
    private Booking booking;

    public BookingResult(boolean success, String message, Booking booking) {
        this.success = success;
        this.message = message;
        this.booking = booking;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Booking getBooking() {
        return booking;
    }
}
