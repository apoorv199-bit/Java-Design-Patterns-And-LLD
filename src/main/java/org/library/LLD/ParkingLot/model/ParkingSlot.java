package org.library.LLD.ParkingLot.model;

import org.library.LLD.ParkingLot.constants.VehicleType;

public abstract class ParkingSlot {
    private String parkingSlotNumber;
    private Vehicle vehicle;
    private boolean isOccupied;
    private VehicleType spotType;
    private int distanceFromEntry;

    public ParkingSlot(String parkingSlotNumber, VehicleType spotType, int distanceFromEntry) {
        this.parkingSlotNumber = parkingSlotNumber;
        this.spotType = spotType;
        this.isOccupied = false;
        this.distanceFromEntry = distanceFromEntry;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public int getDistanceFromEntry() {
        return this.distanceFromEntry;
    }

    public VehicleType getSpotType(){
        return this.spotType;
    }

    public void releaseSlot(){
        this.isOccupied = false;
    }

    public String getParkingSlotNumber(){
        return this.parkingSlotNumber;
    }
}
