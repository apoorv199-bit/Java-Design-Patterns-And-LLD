package org.library.LLD.FitnessClassBookingSystem.models;

import org.library.LLD.FitnessClassBookingSystem.enums.BookingStatus;

import java.time.LocalDateTime;

public class Booking {
    private String bookingId;
    private String userId;
    private String classId;
    private LocalDateTime bookingTime;
    private BookingStatus status;

    public Booking(String bookingId, String userId, String classId, BookingStatus status) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.classId = classId;
        this.bookingTime = LocalDateTime.now();
        this.status = status;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getClassId() {
        return classId;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
