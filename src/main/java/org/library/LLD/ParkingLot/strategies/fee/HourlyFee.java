package org.library.LLD.ParkingLot.strategies.fee;

import org.library.LLD.ParkingLot.constants.VehicleType;

public class HourlyFee implements ParkingFeeStrategy {

    public double calculateFee(VehicleType vehicleType, long durationInHours) {
        if (vehicleType == VehicleType.TWO_WHEELER) {
            return durationInHours * 10.0;
        } else if (vehicleType == VehicleType.FOUR_WHEELER) {
            return durationInHours * 20.0;
        } else {
            throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}
