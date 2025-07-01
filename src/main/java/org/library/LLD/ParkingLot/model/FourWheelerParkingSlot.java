package org.library.LLD.ParkingLot.model;

import org.library.LLD.ParkingLot.constants.VehicleType;

public class FourWheelerParkingSlot extends ParkingSlot {
    public FourWheelerParkingSlot(String parkingSlotNumber, int distanceFromEntry) {
        super(parkingSlotNumber, VehicleType.FOUR_WHEELER, distanceFromEntry);
    }
}
