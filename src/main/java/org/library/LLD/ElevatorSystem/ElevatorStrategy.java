package org.library.LLD.ElevatorSystem;

import java.util.List;

public interface ElevatorStrategy {
    Elevator getElevator(List<Elevator> elevators, ExternalRequest request);
}
