package org.library.LLD.ParkingLot.model;

import org.library.LLD.ParkingLot.strategies.fee.ParkingFeeStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExitGate {
    private String id;

    public ExitGate(String id){
        this.id = id;
    }

    public Recipt exitVehicle(Ticket ticket, ParkingFeeStrategy feeStrategy){
        ParkingLot.getInstance().releaseSlot(ticket);
        LocalDateTime exitTime = LocalDateTime.now();
        long duration = Math.max(Duration.between(ticket.getEntryTime(), exitTime).toHours(), 1);
        double amount = feeStrategy.calculateFee(ticket.getVehicle().getVehicleType(), duration);
        return new Recipt(ticket, exitTime, amount);
    }
}
