package org.library.LLD.ParkingLot.model;

import org.library.LLD.ParkingLot.constants.VehicleType;

public class FourWheeler extends Vehicle {
    public FourWheeler(String licenseNumber){
        super(licenseNumber, VehicleType.FOUR_WHEELER);
    }
}
