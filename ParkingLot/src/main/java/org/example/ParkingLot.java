package org.example;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<Floor> floors = new ArrayList<>();


    public ParkingLot(Integer noOfFloors, Integer noOfSlotsPerEachFloors){

        for(int i=0; i< noOfFloors; i++){

            floors.add(new Floor(i, noOfSlotsPerEachFloors));

        }

    }

    public Integer numberOfCarsOfColor(Color desiredColor){

        Integer noOfCars = 0;

        for(Floor floor : floors){
            noOfCars += floor.noOfCarsOfParticularColor(desiredColor);
        }

        return noOfCars;

    }

    public void addFloor(Floor floor){

        this.floors.add(floor);


    }

    public Integer getNoOfFloors(){

        return this.floors.size();

    }

    public void addCarToEmptySlot(Car car) throws IllegalStateException{

        if(isFull()){
            throw new IllegalStateException("Sorry, can't park parking lot is full.");
        }

        for(Floor floor : floors){

            if(!floor.ifFloorIsFull()){
                floor.addCarToEmptySlot(car);
                return;
            }

        }

    }

    public Integer getNumberOfEmptySlots(){

        Integer numOfEmptySlots = 0;
        for(Floor floor : this.floors){

            if(!floor.ifFloorIsFull()){
                numOfEmptySlots += floor.getNoOfEmptySlots();
            }

        }

        return numOfEmptySlots;
    }


    public Boolean isFull(){

        for(Floor floor : this.floors){

            if(!floor.ifFloorIsFull()){
                return false;
            }

        }

        return true;

    }

    public void unparkFromParkingLot(Car car) throws IllegalStateException{

        for(Floor floor : this.floors){

            if(floor.checkParticularCarPresentOrNot(car)){
                floor.unparkFromFloor(car);
                return;
            }

        }

        throw new IllegalStateException("Car not found");


    }



}
