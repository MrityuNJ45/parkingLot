package org.example;

import java.util.Optional;

public class Slot {

    private Integer slotNo ;

    private Optional<Car> car;

    public Slot(Integer slotNo) {
        this.slotNo = slotNo;
        this.car = Optional.empty();

    }

    public void park(Car car){

        if(this.isEmpty()) {
            this.car  = Optional.of(car);
        }

    }

    public Boolean particularCarPresentOrNot(Car car){

        return this.car.equals(Optional.of(car));

    }



    public Boolean isEmpty(){

        return this.car.isEmpty();

    }

    public Boolean isColorOfCarPresent(Color desiredColor){
        if(this.car.isPresent()) return this.car.get().isOfColor(desiredColor);
        return false;
    }

    public Slot giveEmptySlot(){
        return this;
    }

    public void unpark(Car car) throws IllegalStateException{
        if(car.equals(this.car.get())){
            this.car = Optional.empty();
            return;
        }
        throw new IllegalStateException("Invalid Car details...");
    }



}
