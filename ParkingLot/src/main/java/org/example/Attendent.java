package org.example;

public class Attendent {

    // JobOfClass : To take park a car and take a token to unpark a car.

    private String attendeeName;

    private AttendentHelper attendentHelper;


    public Attendent(String attendeeName, AttendentHelper attendentHelper) {
        this.attendeeName = attendeeName;
        this.attendentHelper = attendentHelper;
    }


    public Token park(Car car) throws IllegalStateException {
        return this.attendentHelper.park(car);
    }

    public Car unpark(Token token) throws IllegalStateException {
         return attendentHelper.unpark(token);
    }


}
