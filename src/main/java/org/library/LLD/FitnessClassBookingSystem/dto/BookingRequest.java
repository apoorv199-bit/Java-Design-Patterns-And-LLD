package org.library.LLD.FitnessClassBookingSystem.dto;

public class BookingRequest {
    private String userId;
    private String classId;

    public BookingRequest(String userId, String classId) {
        this.userId = userId;
        this.classId = classId;
    }

    public String getUserId() {
        return userId;
    }

    public String getClassId() {
        return classId;
    }
}
