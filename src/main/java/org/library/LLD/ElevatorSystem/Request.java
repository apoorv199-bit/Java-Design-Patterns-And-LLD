package org.library.LLD.ElevatorSystem;

public abstract class Request {
    private int floor;

    public Request(int floor){
        this.floor = floor;
    }

    public int getFloor(){
        return this.floor;
    }

}
