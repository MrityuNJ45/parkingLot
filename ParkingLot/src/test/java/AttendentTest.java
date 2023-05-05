import static org.junit.Assert.*;

import org.example.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AttendentTest {


    //TODO : do assertDoesNotThrow after installing junit - 5

    @Test
    public void expectsToParkACarWhenEmptySlotIsThere(){

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        AttendentHelper attendentHelper = new AttendentHelper(parkingLots);
        Attendent attendent = new Attendent("Mohit", attendentHelper);
        attendent.park(new Car("12345", Color.Red));
        assertTrue(parkingLots.get(0).isFull());

    }

    @Test
    public void expectsToThrowACarWhenEmptySlotIsNotThere(){

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        AttendentHelper attendentHelper = new AttendentHelper(parkingLots);
        Attendent attendent = new Attendent("Mohit", attendentHelper);
        attendent.park(new Car("12345", Color.Red));
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            attendent.park(new Car("78945", Color.Green));
        });
        assertEquals("Sorry, can't park at the moment parking lot is full", thrown.getMessage());

    }

    @Test
    public void expectsToUnparkACarWhenValidTokenIsGiven(){

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        AttendentHelper attendentHelper = new AttendentHelper(parkingLots);
        Attendent attendent = new Attendent("Mohit", attendentHelper);
        Token token = attendent.park(new Car("123456", Color.Green));
        attendent.unpark(token);
        assertFalse(parkingLots.get(0).isFull());

    }

    @Test
    public void expectsToThrowExceptionWhenInvalidTokenIsGivenForUnpark(){

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        AttendentHelper attendentHelper = new AttendentHelper(parkingLots);
        Attendent attendent = new Attendent("Mohit", attendentHelper);
        Token token = attendent.park(new Car("123456", Color.Green));
        Token randomToken = new Token();
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            attendent.unpark(randomToken);
        });
        assertEquals("Invalid token Given...", thrown.getMessage());


    }






}
