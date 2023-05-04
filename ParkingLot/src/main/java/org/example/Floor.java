package org.example;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private Integer floorNo;

    private List<Slot> slots ;

    public Floor(Integer floorNo, Integer noOfSlotsPerFloor){

        this.floorNo = floorNo;
        ArrayList<Slot> creatingSlots = new ArrayList<>();
        for(int i=1; i<=noOfSlotsPerFloor; i++){

            creatingSlots.add(new Slot(i));

        }

        this.slots = creatingSlots;

    }

    public Boolean ifFloorIsFull(){

        for(Slot slot : this.slots){
            if(slot.isEmpty()){
                return false;
            }
        }

        return true;

    }

    public void addCarToEmptySlot(Car car){

        for(Slot slot : this.slots){

            if(slot.isEmpty()){

                slot.park(car);
                return;
            }


        }


    }


    public Integer noOfCarsOfParticularColor(Color desiredColor){

        Integer noOfCars = 0;

        for(Slot slot : this.slots){

            if(slot.isColorOfCarPresent(desiredColor)) noOfCars++;

        }

        return noOfCars;
    }

    public Integer getNoOfEmptySlots(){


        Integer noOfEmptySlots = 0;
        for(Slot slot : this.slots){


            if(slot.isEmpty()){
                noOfEmptySlots++;
            }

        }
        return noOfEmptySlots;

    }

    public Boolean checkParticularCarPresentOrNot(Car car){

        for(Slot slot : this.slots){

            if(slot.particularCarPresentOrNot(car)){
                return true;
            }

        }

        return false;

    }

    public void unparkFromFloor(Car car) throws IllegalStateException{

        for(Slot slot : this.slots){

            if(slot.particularCarPresentOrNot(car)){
                slot.unpark(car);
                return;
            }

        }

        throw new IllegalStateException("Car not found...");


    }





}
