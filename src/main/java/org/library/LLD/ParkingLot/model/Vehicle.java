package org.library.LLD.ParkingLot.model;

import org.library.LLD.ParkingLot.constants.VehicleType;

public abstract class Vehicle {
    private String licenseNumber;
    private VehicleType vehicleType;

    public Vehicle(String licenseNumber, VehicleType vehicleType) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }
}
