package org.library.LLD.ElevatorSystem;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {
    private int elevatorId;
    private Display display;
    private int currentFloor;
    private Direction direction;
    private Status status;
    private InternalButtons button;
    private Queue<Request> requests;

    public Elevator(int elevatorId){
        this.elevatorId = elevatorId;
        this.currentFloor = 0;
        this.status = Status.IDLE;
        this.direction = null;
        this.button = new InternalButtons();
        this.requests = new LinkedList<>();
    }

    public InternalButtons getButton(){
        return this.button;
    }

    public int getElevatorId(){
        return this.elevatorId;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public int getCurrentFloor(){
        return this.currentFloor;
    }

    public Status getStatus(){
        return this.status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public void addRequest(Request request){
        boolean exist = requests.stream()
                .anyMatch(r -> r.getFloor() == request.getFloor());
        if(!exist){
            requests.add(request);
        }
    }

    public Queue<Request> getRequestsQueue() {
        return this.requests;
    }

//    public void move() {
//        if (requests == null || requests.isEmpty()) {
//            setStatus(Status.IDLE);
//            direction = null;
//            return;
//        }
//
//        setStatus(Status.RUNNING);
//        SchedulingStrategy strategy = new LookSchedulingStrategy();
//
//        while (!requests.isEmpty()) {
//            int nextStop = strategy.getNextStop(this);
//
//            // Set direction
//            if (nextStop > currentFloor) {
//                direction = Direction.UP;
//            } else if (nextStop < currentFloor) {
//                direction = Direction.DOWN;
//            } else {
//                direction = null; // already at the floor
//            }
//
//            // Move elevator to nextStop
//            currentFloor = nextStop;
//            setStatus(Status.STOPPED);
//
//            // Remove all requests for current floor
//            requests.removeIf(r -> r.getFloor() == currentFloor);
//
//            // Optional: update display or log action
//            System.out.println("Elevator " + elevatorId + " stopped at floor " + currentFloor);
//        }
//
//        // All requests processed
//        setStatus(Status.IDLE);
//        direction = null;
//    }
public void move() {
    if (requests == null || requests.isEmpty()) {
        setStatus(Status.IDLE);
        direction = null;
        return;
    }

    setStatus(Status.RUNNING);
    SchedulingStrategy strategy = new LookSchedulingStrategy();

    while (!requests.isEmpty()) {
        int nextStop = strategy.getNextStop(this);

        // Set direction
        if (nextStop > currentFloor) {
            direction = Direction.UP;
        } else if (nextStop < currentFloor) {
            direction = Direction.DOWN;
        } else {
            direction = null; // already at the floor
        }

        // Simulate movement one floor at a time
        while (currentFloor != nextStop) {
            if (direction == Direction.UP) {
                currentFloor++;
            } else if (direction == Direction.DOWN) {
                currentFloor--;
            }
            System.out.println("Elevator " + elevatorId + " moving " + direction + " - floor " + currentFloor);
            try {
                Thread.sleep(10000); // Simulate 1 second delay per floor
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Reached floor
        setStatus(Status.STOPPED);
        System.out.println("Elevator " + elevatorId + " stopped at floor " + currentFloor);
        System.out.println("Doors opening...");

        try {
            Thread.sleep(5000); // Simulate door opening time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Doors closing...");

        // Remove all requests for current floor
        requests.removeIf(r -> r.getFloor() == currentFloor);
    }

    // All requests processed
    setStatus(Status.IDLE);
    direction = null;
    System.out.println("Elevator " + elevatorId + " is now IDLE at floor " + currentFloor);
}


}
