package org.library.LLD.FitnessClassBookingSystem.dto;

import org.library.LLD.FitnessClassBookingSystem.enums.ClassType;

import java.time.LocalDateTime;

public class ClassCreationRequest {
    private String className;
    private ClassType type;
    private String instructor;
    private LocalDateTime scheduledTime;
    private int capacity;

    public ClassCreationRequest(String className, ClassType type, String instructor, LocalDateTime scheduledTime, int capacity) {
        this.className = className;
        this.type = type;
        this.instructor = instructor;
        this.scheduledTime = scheduledTime;
        this.capacity = capacity;
    }

    public String getClassName() {
        return className;
    }

    public ClassType getType() {
        return type;
    }

    public String getInstructor() {
        return instructor;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public int getCapacity() {
        return capacity;
    }
}
