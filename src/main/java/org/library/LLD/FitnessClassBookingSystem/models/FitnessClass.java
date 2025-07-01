package org.library.LLD.FitnessClassBookingSystem.models;

import org.library.LLD.FitnessClassBookingSystem.enums.ClassType;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FitnessClass {
    private String classId;
    private String className;
    private ClassType type;
    private String instructor;
    private LocalDateTime scheduledTime;
    private int capacity;
    private int currentAttendees;
    private boolean isActive;
    private Set<String> bookedUsers;
    private Queue<String> waitlist;
    private final ReentrantReadWriteLock lock;

    public FitnessClass(String classId, String className, ClassType type, String instructor, LocalDateTime scheduledTime, int capacity){
        this.classId = classId;
        this.className = className;
        this.type = type;
        this.instructor = instructor;
        this.scheduledTime = scheduledTime;
        this.capacity = capacity;
        this.currentAttendees = 0;
        this.isActive = true;
        this.bookedUsers = new HashSet<>();
        this.waitlist = new LinkedList<>();
        this.lock = new ReentrantReadWriteLock();
    }

    public String getClassId() {
        return classId;
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

    public int getCurrentAttendees() {
        return currentAttendees;
    }

    public boolean isActive() {
        return isActive;
    }

    public Set<String> getBookedUsers() {
        return bookedUsers;
    }

    public Queue<String> getWaitlist() {
        return waitlist;
    }

    public void setActive(boolean active){
        this.isActive = active;
    }

    public boolean isFull(){
        lock.readLock().lock();
        try{
            return currentAttendees >= capacity;
        }finally {
            lock.readLock().unlock();
        }
    }

    public boolean addUser(String userId){
        lock.writeLock().lock();
        try{
            if(!isActive){
                return false;
            }

            if(currentAttendees < capacity){
                bookedUsers.add(userId);
                currentAttendees++;
                return true;
            }else {
                waitlist.offer(userId);
                return false;
            }
        }finally {
            lock.writeLock().unlock();
        }
    }

    public String removeUser(String userId){
        lock.writeLock().lock();
        try {
            if (bookedUsers.contains(userId)){
                bookedUsers.remove(userId);
                currentAttendees--;

                if (!waitlist.isEmpty()){
                    String nextUserId = waitlist.poll();
                    bookedUsers.add(nextUserId);
                    currentAttendees++;
                    return nextUserId;
                }
            }else {
                waitlist.remove(userId);
            }
            return null;
        }finally {
            lock.writeLock().unlock();
        }
    }

    public boolean isUserBooked(String userId){
        lock.readLock().lock();
        try {
            return bookedUsers.contains(userId);
        }finally {
            lock.readLock().unlock();
        }
    }

    public boolean isUserWaitlisted(String userId){
        lock.readLock().lock();
        try {
            return waitlist.contains(userId);
        }finally {
            lock.readLock().unlock();
        }
    }
}
