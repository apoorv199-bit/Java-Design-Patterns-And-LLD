package org.library.LLD.ParkingLot.model;

import org.library.LLD.ParkingLot.constants.VehicleType;

public class TwoWheeler extends Vehicle {
    public TwoWheeler(String licenseNumber) {
        super(licenseNumber, VehicleType.TWO_WHEELER);
    }
}
