package org.library.LLD.ElevatorSystem;

import java.util.Comparator;
import java.util.List;

public class NearestElevatorStrategy implements ElevatorStrategy{
//    @Override
//    public Elevator getElevator(List<Elevator> elevators, ExternalRequest request) {
//        return elevators.stream()
//                .filter(e ->
//                        e.getStatus() == Status.IDLE || // consider idle elevators
//                                e.getDirection() == request.getDirection())
//                .min(Comparator.comparingInt(e -> Math.abs(e.getCurrentFloor() - request.getFloor())))
//                .orElse(null);
//    }
    @Override
    public Elevator getElevator(List<Elevator> elevators, ExternalRequest request) {
        return elevators.stream()
                .filter(elevator -> {
                    if (elevator.getStatus() == Status.IDLE) {
                        return true;
                    }

                    if (elevator.getDirection() != request.getDirection()) {
                        return false;
                    }

                    int currentFloor = elevator.getCurrentFloor();
                    int requestFloor = request.getFloor();

                    // Elevator should be moving toward the request floor
                    if (request.getDirection() == Direction.UP) {
                        return currentFloor <= requestFloor;
                    } else {
                        return currentFloor >= requestFloor;
                    }
                })
                .min(Comparator.comparingInt(e -> Math.abs(e.getCurrentFloor() - request.getFloor())))
                .orElse(null);
    }

}
