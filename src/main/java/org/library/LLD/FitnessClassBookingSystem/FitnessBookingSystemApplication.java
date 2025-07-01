package org.library.LLD.FitnessClassBookingSystem;

import org.library.LLD.FitnessClassBookingSystem.controllers.FitnessBookingController;
import org.library.LLD.FitnessClassBookingSystem.dto.BookingResult;
import org.library.LLD.FitnessClassBookingSystem.enums.ClassType;
import org.library.LLD.FitnessClassBookingSystem.enums.UserTier;
import org.library.LLD.FitnessClassBookingSystem.models.Booking;
import org.library.LLD.FitnessClassBookingSystem.models.FitnessClass;
import org.library.LLD.FitnessClassBookingSystem.models.User;

import java.time.LocalDateTime;
import java.util.List;

public class FitnessBookingSystemApplication {
    public static void main(String[] args){
        FitnessBookingController controller = new FitnessBookingController();

        controller.registerUser("John Doe", "john@email.com", "password123", UserTier.PLATINUM);
        controller.registerUser("Jane Smith", "jane@email.com", "password456", UserTier.GOLD);
        controller.registerUser("Bob Wilson", "bob@email.com", "password789", UserTier.SILVER);

        User john = controller.login("john@email.com", "password123");
        User jane = controller.login("jane@email.com", "password456");
        User bob = controller.login("bob@email.com", "password789");

        System.out.println("Users registered and logged in successfully!");

        LocalDateTime classTime1 = LocalDateTime.now().plusHours(2);
        LocalDateTime classTime2 = LocalDateTime.now().plusHours(4);

        String yogaClassId = controller.createClass("Morning Yoga", ClassType.YOGA, "Sarah", classTime1, 2);
        String gymClassId = controller.createClass("HIIT Training", ClassType.GYM, "Mike", classTime2, 1);

        System.out.println("Classes created successfully!");

        BookingResult result1 = controller.bookClass(john.getUserId(), yogaClassId);
        System.out.println("John's booking: " + result1.getMessage());

        BookingResult result2 = controller.bookClass(jane.getUserId(), yogaClassId);
        System.out.println("Jane's booking: " + result2.getMessage());

        BookingResult result3 = controller.bookClass(bob.getUserId(), yogaClassId);
        System.out.println("Bob's booking: " + result3.getMessage() + " (Should be waitlisted)");

        boolean cancelled = controller.cancelBooking(john.getUserId(), yogaClassId);
        System.out.println("John's cancellation: " + (cancelled ? "Success" : "Failed"));

        FitnessClass yogaClass = controller.getClassDetails(yogaClassId);
        System.out.println("Yoga class attendees: " + yogaClass.getCurrentAttendees() + "/" + yogaClass.getCapacity());
        System.out.println("Waitlist size: " + yogaClass.getWaitlist().size());

        System.out.println("\n=== User Bookings ===");
        List<Booking> johnBookings = controller.getUserBookings(john.getUserId());
        System.out.println("John's bookings: " + johnBookings.size());
        if (!johnBookings.isEmpty()) {
            System.out.println("John's first booking status: " + johnBookings.get(0).getStatus());
        }

        List<Booking> bobBookings = controller.getUserBookings(bob.getUserId());
        System.out.println("Bob's bookings: " + bobBookings.size());
        if (!bobBookings.isEmpty()) {
            System.out.println("Bob's first booking status: " + bobBookings.get(0).getStatus());
        }
    }
}
