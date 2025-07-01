package org.library.LLD.ParkingLot.model;

import org.library.LLD.ParkingLot.constants.VehicleType;
import org.library.LLD.ParkingLot.strategies.parking.NearestToEntrance;
import org.library.LLD.ParkingLot.strategies.parking.ParkingStrategy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static final ParkingLot PARKING_LOT_INSTANCE = new ParkingLot();
    private List<EntranceGate> entranceGates = new ArrayList<>();
    private final Map<VehicleType, PriorityQueue<ParkingSlot>> availableParkingSlots = new ConcurrentHashMap<>();
    private ParkingStrategy parkingStrategy;

    private ParkingLot() {
        for (VehicleType type : VehicleType.values()) {
            availableParkingSlots.put(type,
                    new PriorityQueue<>(Comparator.comparingInt(ParkingSlot::getDistanceFromEntry)));
        }
        this.parkingStrategy = new NearestToEntrance();
    }

    public static ParkingLot getInstance(){
        return PARKING_LOT_INSTANCE;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy){
        this.parkingStrategy = parkingStrategy;
    }

    public void addParkingSlot(ParkingSlot slot){
        availableParkingSlots.get(slot.getSpotType()).add(slot);
    }

    public ParkingSlot assignSlot(Vehicle vehicle){
        ParkingSlot parkingSlot = parkingStrategy.findParkingSlot(vehicle, availableParkingSlots);
        if(parkingSlot != null){
            parkingSlot.parkVehicle(vehicle);
            return parkingSlot;
        }else {
            throw new RuntimeException("No spot available for vehicle type: " + vehicle.getVehicleType());
        }
    }

    public void releaseSlot(Ticket ticket){
        ParkingSlot slot = ticket.getParkingSlot();
        slot.releaseSlot();
        availableParkingSlots.get(slot.getSpotType()).add(slot);
    }
}
