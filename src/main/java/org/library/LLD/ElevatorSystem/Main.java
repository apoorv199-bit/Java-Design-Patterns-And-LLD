package org.library.LLD.ElevatorSystem;

public class Main {
//    public static void main(String[] args){
//        ElevatorController controller = ElevatorController.getInstance();
//        controller.addElevator(new Elevator(1));
//        controller.addElevator(new Elevator(2));
//        controller.addElevator(new Elevator(3));
//        controller.addElevator(new Elevator(4));
//
//        ExternalButtons extButton = new ExternalButtons();
//        Elevator elevator = extButton.press(3, Direction.DOWN);
//        elevator.getButton().press(elevator, 1);
//        Elevator elevator1 = extButton.press(4, Direction.DOWN);
//        elevator1.getButton().press(elevator1, 5);
//        Elevator elevator2 = extButton.press(2, Direction.UP);
//        elevator2.getButton().press(elevator2, 3);
//
//    }
    public static void main(String[] args){
        ElevatorController controller = ElevatorController.getInstance();
        controller.addElevator(new Elevator(1));
        controller.addElevator(new Elevator(2));
        controller.addElevator(new Elevator(3));
        controller.addElevator(new Elevator(4));

        ExternalButtons extButton = new ExternalButtons();

        System.out.println("Sending request from floor 3 to go DOWN");
        Elevator elevator = extButton.press(3, Direction.DOWN);
        elevator.getButton().press(elevator, 0);

        System.out.println("Sending request from floor 4 to go DOWN");
        Elevator elevator1 = extButton.press(4, Direction.DOWN);
        elevator1.getButton().press(elevator1, 2);

        System.out.println("Sending request from floor 2 to go UP");
        Elevator elevator2 = extButton.press(3, Direction.UP);
        elevator2.getButton().press(elevator2, 6);
    }

}
