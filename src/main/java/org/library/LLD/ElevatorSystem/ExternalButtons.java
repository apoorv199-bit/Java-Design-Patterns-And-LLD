package org.library.LLD.ElevatorSystem;

public class ExternalButtons {
    private Direction direction;
    private int floor;
    private final ElevatorController controller = ElevatorController.getInstance();

    public Elevator press(int floor, Direction direction){
        this.floor = floor;
        this.direction = direction;
        return controller.requestElevator(new ExternalRequest(floor, direction));
    }
}
