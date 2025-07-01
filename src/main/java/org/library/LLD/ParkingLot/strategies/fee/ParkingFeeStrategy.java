package org.library.LLD.ParkingLot.strategies.fee;

import org.library.LLD.ParkingLot.constants.VehicleType;

public interface ParkingFeeStrategy {
    public double calculateFee(VehicleType vehicleType, long durationInHours);
}
