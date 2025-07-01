package org.library.LLD.FitnessClassBookingSystem.services;

import org.library.LLD.FitnessClassBookingSystem.dto.BookingResult;
import org.library.LLD.FitnessClassBookingSystem.enums.BookingStatus;
import org.library.LLD.FitnessClassBookingSystem.exceptions.BookingLimitExceededException;
import org.library.LLD.FitnessClassBookingSystem.exceptions.InvalidBookingException;
import org.library.LLD.FitnessClassBookingSystem.models.Booking;
import org.library.LLD.FitnessClassBookingSystem.models.FitnessClass;
import org.library.LLD.FitnessClassBookingSystem.models.User;
import org.library.LLD.FitnessClassBookingSystem.utils.IDGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BookingService {
    private Map<String, Booking> bookings;
    private UserService userService;
    private ClassService classService;

    public BookingService(UserService userService, ClassService classService){
        this.bookings = new ConcurrentHashMap<>();
        this.userService = userService;
        this.classService = classService;
    }

    public synchronized BookingResult bookClass(String userId, String classId){
        User user = userService.getUserById(userId);
        FitnessClass fitnessClass = classService.getClassById(classId);

        if (!fitnessClass.isActive()){
            throw new InvalidBookingException("Class is cancelled");
        }
        if (fitnessClass.getScheduledTime().isBefore(LocalDateTime.now())){
            throw new InvalidBookingException("Class has already started");
        }
        if (user.getBookedClasses().contains(classId)){
            throw new InvalidBookingException("Already booked this class");
        }
        if (!user.canBook()){
            throw new BookingLimitExceededException("Booking limit reached for your tier. Upgrade tier to book more classes!");
        }

        boolean booked = fitnessClass.addUser(userId);
        String bookingId = IDGenerator.generateBookingId();

        if(booked){
            Booking booking = new Booking(bookingId, userId, classId, BookingStatus.CONFIRMED);
            bookings.put(bookingId, booking);
            user.incrementBookings();
            user.addBookedClass(classId);
            return new BookingResult(true, "Class booked successfully", booking);
        }else {
            Booking booking = new Booking(bookingId, userId, classId, BookingStatus.WAITLISTED);
            bookings.put(bookingId, booking);
            return new BookingResult(true, "Added to waitlist", booking);
        }
    }

    public synchronized boolean cancelBooking(String userId, String classId){
        User user = userService.getUserById(userId);
        FitnessClass fitnessClass = classService.getClassById(classId);

        if(fitnessClass.getScheduledTime().minusMinutes(30).isBefore(LocalDateTime.now())){
            throw new InvalidBookingException("Too late to cancel - must cancel at least 30 minutes before class starts");
        }

        String promotedUserId = fitnessClass.removeUser(userId);

        if(user.getBookedClasses().contains(classId)){
            user.decrementBookings();
            user.removeBookedClass(classId);
        }

        updateBookingStatus(userId, classId, BookingStatus.CANCELLED);

        if(promotedUserId != null){
            User promotedUser = userService.getUserById(promotedUserId);
            if (promotedUser != null && promotedUser.canBook()){
                promotedUser.addBookedClass(classId);
                promotedUser.incrementBookings();
                updateBookingStatus(promotedUserId, classId, BookingStatus.CONFIRMED);
            }
        }

        return true;
    }

    public List<Booking> getUserBookings(String userId){
        List<Booking> userBookings = new ArrayList<>();
        for (Booking booking : bookings.values()){
            if (booking.getUserId().equals(userId)){
                userBookings.add(booking);
            }
        }
        return userBookings;
    }

    private void updateBookingStatus(String userId, String classId, BookingStatus status){
        for (Booking booking : bookings.values()){
            if (booking.getUserId().equals(userId) && booking.getClassId().equals(classId)){
                booking.setStatus(status);
                break;
            }
        }
    }
}
