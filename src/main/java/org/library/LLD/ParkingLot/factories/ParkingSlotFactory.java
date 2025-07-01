package org.library.LLD.ParkingLot.factories;

import org.library.LLD.ParkingLot.model.FourWheelerParkingSlot;
import org.library.LLD.ParkingLot.model.ParkingSlot;
import org.library.LLD.ParkingLot.model.TwoWheelerParkingSlot;
import org.library.LLD.ParkingLot.constants.VehicleType;

public class ParkingSlotFactory {
    public static ParkingSlot createParkingSlot(VehicleType slotType, String parkingSlotNumber, int distanceFromEntry){
        switch (slotType){
            case TWO_WHEELER:
                return new TwoWheelerParkingSlot(parkingSlotNumber, distanceFromEntry);
            case FOUR_WHEELER:
                return new FourWheelerParkingSlot(parkingSlotNumber, distanceFromEntry);
            default:
                throw new IllegalArgumentException("Unknown slot type: " + slotType);
        }
    }
}
