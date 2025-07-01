package org.library.LLD.ParkingLot;

import org.library.LLD.ParkingLot.constants.VehicleType;
import org.library.LLD.ParkingLot.factories.VehicleFactory;
import org.library.LLD.ParkingLot.factories.ParkingSlotFactory;
import org.library.LLD.ParkingLot.model.*;
import org.library.LLD.ParkingLot.strategies.fee.HourlyFee;

public class Main {
    public static void main(String[] args){
        ParkingLot parkingLot = ParkingLot.getInstance();

        parkingLot.addParkingSlot(ParkingSlotFactory.createParkingSlot(VehicleType.TWO_WHEELER, "P1", 1));
        parkingLot.addParkingSlot(ParkingSlotFactory.createParkingSlot(VehicleType.TWO_WHEELER, "P2", 5));
        parkingLot.addParkingSlot(ParkingSlotFactory.createParkingSlot(VehicleType.TWO_WHEELER, "P3", 3));
        parkingLot.addParkingSlot(ParkingSlotFactory.createParkingSlot(VehicleType.FOUR_WHEELER, "PP5", 6));
        parkingLot.addParkingSlot(ParkingSlotFactory.createParkingSlot(VehicleType.FOUR_WHEELER, "PP4", 2));
        parkingLot.addParkingSlot(ParkingSlotFactory.createParkingSlot(VehicleType.FOUR_WHEELER, "PP6", 10));
        parkingLot.addParkingSlot(ParkingSlotFactory.createParkingSlot(VehicleType.TWO_WHEELER, "P6", 7));


        EntranceGate entranceGate = new EntranceGate("E1");
        ExitGate exitGate = new ExitGate("X1");

        Vehicle v1 = VehicleFactory.createVehicle("HF2506", VehicleType.TWO_WHEELER);
        Vehicle v2 = VehicleFactory.createVehicle("HF3456", VehicleType.FOUR_WHEELER);

        Ticket ticket1 = entranceGate.enterVehicle(v1);
        Ticket ticket2 = entranceGate.enterVehicle(v2);

        System.out.println("Tickets issued:");
        System.out.println("Ticket1: " + ticket1.getTicketNumber() + ", Spot: " + ticket1.getParkingSlot().getParkingSlotNumber());
        System.out.println("Ticket2: " + ticket2.getTicketNumber() + ", Spot: " + ticket2.getParkingSlot().getParkingSlotNumber());


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Recipt recipt = exitGate.exitVehicle(ticket1, new HourlyFee());
        Recipt recipt1 = exitGate.exitVehicle(ticket2, new HourlyFee());

        System.out.println("\nReceipts:");
        System.out.println(recipt);
        System.out.println(recipt1);

    }
}
