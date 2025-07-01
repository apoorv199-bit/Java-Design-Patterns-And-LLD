package org.library.LLD.ParkingLot.strategies.parking;

import org.library.LLD.ParkingLot.model.Vehicle;
import org.library.LLD.ParkingLot.constants.VehicleType;
import org.library.LLD.ParkingLot.model.ParkingSlot;

import java.util.Map;
import java.util.PriorityQueue;

public class NearestToEntrance implements ParkingStrategy {

    @Override
    public ParkingSlot findParkingSlot(Vehicle vehicle, Map<VehicleType, PriorityQueue<ParkingSlot>> availableParkingSlots) {

        PriorityQueue<ParkingSlot> parkingSlots = availableParkingSlots.get(vehicle.getVehicleType());
        while (!parkingSlots.isEmpty()) {
            ParkingSlot parkingSlot = parkingSlots.poll();
            if (!parkingSlot.isOccupied()) {
                return parkingSlot;
            }
        }
        return null;
    }
}
