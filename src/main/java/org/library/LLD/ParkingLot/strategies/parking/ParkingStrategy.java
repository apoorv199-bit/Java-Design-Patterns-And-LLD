package org.library.LLD.ParkingLot.strategies.parking;

import org.library.LLD.ParkingLot.model.ParkingSlot;
import org.library.LLD.ParkingLot.model.Vehicle;
import org.library.LLD.ParkingLot.constants.VehicleType;

import java.util.Map;
import java.util.PriorityQueue;

public interface ParkingStrategy {
    public ParkingSlot findParkingSlot(Vehicle vehicle,
                                       Map<VehicleType, PriorityQueue<ParkingSlot>> availableParkingSlots);
}
