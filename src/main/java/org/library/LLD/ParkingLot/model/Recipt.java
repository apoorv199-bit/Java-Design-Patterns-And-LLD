package org.library.LLD.ParkingLot.model;

import java.time.LocalDateTime;

public class Recipt {
    private Ticket ticket;
    private LocalDateTime exitTime;
    private double amount;

    public Recipt(Ticket ticket, LocalDateTime exitTime, double amount) {
        this.ticket = ticket;
        this.exitTime = exitTime;
        this.amount = amount;
    }

    public String toString(){
        return "Receipt: " + ticket.getTicketNumber() + ", Amount: ₹" + amount;
    }
}
