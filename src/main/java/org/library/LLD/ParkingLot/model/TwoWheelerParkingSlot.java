package org.library.LLD.ParkingLot.model;

import org.library.LLD.ParkingLot.constants.VehicleType;

public class TwoWheelerParkingSlot extends ParkingSlot {
    public TwoWheelerParkingSlot(String parkingSlotNumber, int distanceFromEntry) {
        super(parkingSlotNumber, VehicleType.TWO_WHEELER, distanceFromEntry);
    }
}
