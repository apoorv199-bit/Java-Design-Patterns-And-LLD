package org.library.LLD.ParkingLot.factories;

import org.library.LLD.ParkingLot.model.FourWheeler;
import org.library.LLD.ParkingLot.model.TwoWheeler;
import org.library.LLD.ParkingLot.model.Vehicle;
import org.library.LLD.ParkingLot.constants.VehicleType;

public class VehicleFactory {
    public static Vehicle createVehicle(String licenseNumber, VehicleType vehicleType){
        switch (vehicleType){
            case TWO_WHEELER:
                return new TwoWheeler(licenseNumber);
            case FOUR_WHEELER:
                return new FourWheeler(licenseNumber);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }
    }
}
