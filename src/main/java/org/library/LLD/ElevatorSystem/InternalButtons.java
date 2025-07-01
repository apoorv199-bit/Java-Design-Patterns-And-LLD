package org.library.LLD.ElevatorSystem;

public class InternalButtons {
    private Elevator elevator;
    private int destinationFloor;

    public void press(Elevator elevator, int destinationFloor){
        this.destinationFloor = destinationFloor;
        this.elevator = elevator;
        System.out.println("Internal button pressed in Elevator " + elevator.getElevatorId() + " for floor " + destinationFloor);
        elevator.addRequest(new InternalRequest(destinationFloor));
//        elevator.move();
        if (elevator.getStatus() == Status.IDLE) {
            elevator.setStatus(Status.RUNNING);
            new Thread(elevator::move).start();
        }
    }
}
