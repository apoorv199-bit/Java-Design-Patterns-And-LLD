package org.library.LLD.ElevatorSystem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorController {
    private static final ElevatorController ELEVATOR_CONTROLLER_INSTANCE = new ElevatorController();
    private List<Elevator> elevators;
    private final ElevatorStrategy elevatorStrategy;

    private ElevatorController(){
        this.elevatorStrategy = new NearestElevatorStrategy();
        this.elevators = new LinkedList<>();
    }

    public Elevator requestElevator(ExternalRequest request){
        Elevator elevator = elevatorStrategy.getElevator(elevators, request);
        if (elevator == null) {
            System.out.println("No suitable elevator found for the request.");
            return null;
        }

        elevator.addRequest(request);
//        if (elevator.getStatus() == Status.IDLE) {
//            elevator.setStatus(Status.RUNNING);
//            elevator.move();
//        }
        if (elevator.getStatus() == Status.IDLE) {
            elevator.setStatus(Status.RUNNING);
            new Thread(elevator::move).start();
        }
        return elevator;
    }

    public static ElevatorController getInstance(){
        return ELEVATOR_CONTROLLER_INSTANCE;
    }

    public void addElevator(Elevator elevator){
        elevators.add(elevator);
    }
}
