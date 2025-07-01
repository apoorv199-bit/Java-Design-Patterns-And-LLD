package org.library.LLD.FitnessClassBookingSystem.controllers;

import org.library.LLD.FitnessClassBookingSystem.dto.BookingResult;
import org.library.LLD.FitnessClassBookingSystem.enums.ClassType;
import org.library.LLD.FitnessClassBookingSystem.enums.UserTier;
import org.library.LLD.FitnessClassBookingSystem.models.Booking;
import org.library.LLD.FitnessClassBookingSystem.models.FitnessClass;
import org.library.LLD.FitnessClassBookingSystem.models.User;
import org.library.LLD.FitnessClassBookingSystem.services.BookingService;
import org.library.LLD.FitnessClassBookingSystem.services.ClassService;
import org.library.LLD.FitnessClassBookingSystem.services.UserService;

import java.time.LocalDateTime;
import java.util.List;

public class FitnessBookingController {

    private UserService userService;
    private ClassService classService;
    private BookingService bookingService;

    public FitnessBookingController(){
        this.userService = new UserService();
        this.classService = new ClassService();
        this.bookingService = new BookingService(userService, classService);
    }

    public boolean registerUser(String name, String email, String password, UserTier tier){
        return userService.registerUser(name, email, password, tier);
    }

    public User login(String email, String password){
        return userService.login(email, password);
    }

    public boolean upgradeUserTier(String userId, UserTier newTier){
        return userService.upgradeUserTier(userId, newTier);
    }

    public String createClass(String className, ClassType type, String instructor, LocalDateTime scheduledTime, int capacity){
        return classService.createClass(className, type, instructor, scheduledTime, capacity);
    }

    public boolean cancelClass(String classId){
        return classService.cancelClass(classId);
    }

    public List<FitnessClass> getAvailableClasses(){
        return classService.getAvailableClasses();
    }

    public List<FitnessClass> getClassesByType(ClassType type){
        return classService.getClassesByType(type);
    }

    public BookingResult bookClass(String userId, String classId){
        return bookingService.bookClass(userId, classId);
    }

    public boolean cancelBooking(String userId, String classId){
        return bookingService.cancelBooking(userId, classId);
    }

    public List<Booking> getUserBookings(String userId){
        return bookingService.getUserBookings(userId);
    }

    public FitnessClass getClassDetails(String classId){
        return classService.getClassById(classId);
    }
}
