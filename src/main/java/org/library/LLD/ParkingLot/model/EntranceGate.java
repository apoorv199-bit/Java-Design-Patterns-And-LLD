package org.library.LLD.ParkingLot.model;

import java.util.UUID;

public class EntranceGate {
    private String id;

    public EntranceGate(String id) {
        this.id = id;
    }

    public Ticket enterVehicle(Vehicle vehicle) {
        ParkingSlot parkingSlot = ParkingLot.getInstance().assignSlot(vehicle);
        return new Ticket(UUID.randomUUID().toString(), vehicle, parkingSlot);
    }

    public String getId(){
        return this.id;
    }
}
