package org.example;

import java.util.List;

public class AttendentHelper {

    private List<ParkingLot> parkingLots ;


    public AttendentHelper(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }


    public Token park(Car car) throws IllegalStateException{
        for(ParkingLot parkingLot : parkingLots){
            if(!parkingLot.isFull()){
                return parkingLot.addCarToEmptySlot(car);
            }
        }
        throw new IllegalStateException("Sorry, can't park at the moment parking lot is full");
    }


    public Car unpark(Token token) throws IllegalStateException{

        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.ifTokenIsPresentInTheMap(token)) {
                return parkingLot.unparkFromParkingLot(token);
            }
        }
        throw new IllegalStateException("Invalid token Given...");
    }


}
