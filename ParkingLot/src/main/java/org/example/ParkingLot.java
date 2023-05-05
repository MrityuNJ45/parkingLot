package org.example;

import java.util.*;

public class ParkingLot {

    // JobOfClass :

    private List<Slot> slots = new ArrayList<>();
    private HashMap<Token, Car> tokenCarMap = new HashMap<>();


    public ParkingLot(int noOfSlots){
        for(int i=0; i<noOfSlots; i++){
            slots.add(new Slot(i+1));
        }
    }

    public Integer numberOfCarsOfColor(Color desiredColor){
        Integer noOfCars = 0;
        for(Slot slot : this.slots){
            if(slot.isColorOfCarPresent(desiredColor)) {
                noOfCars += 1;
            }
        }
        return noOfCars;
    }





    public Token addCarToEmptySlot(Car car) throws IllegalStateException{
        if(isFull()){
            throw new IllegalStateException("Sorry, can't park parking lot is full.");
        }
        Token token = null;
        for(Slot slot : this.slots){
            if(slot.isEmpty()){
                slot.park(car);
                 token = new Token();
                 this.tokenCarMap.put(token,car);
                break;
            }
        }
        return token;
    }




    public Boolean isFull(){
        for(Slot slot : this.slots){
            if(slot.isEmpty()){
                return false;
            }
        }
        return true;
    }

    public Car unparkFromParkingLot(Token token) throws IllegalStateException{

        Car car = this.tokenCarMap.get(token);
        if(car == null){
            throw new IllegalStateException("Car not found");
        }

       for(Slot slot : this.slots){
           if(slot.particularCarPresentOrNot(car)){
               slot.unpark(car);
               return car;
           }
       }

       throw new IllegalStateException("Car not found");

    }

    public Boolean ifTokenIsPresentInTheMap(Token token){

        Set<Token> tokens =  this.tokenCarMap.keySet();
        return tokens.contains(token);

    }


    public Integer getNumberOfEmptySlots() {
        Integer numOfEmptySlot = 0;
        for(Slot slot : this.slots){
            if(slot.isEmpty()){
                numOfEmptySlot++;
            }
        }
        return numOfEmptySlot;
    }
}
