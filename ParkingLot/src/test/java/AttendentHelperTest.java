import org.example.*;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AttendentHelperTest {

    @Test
    public void expectsAttendentHelperToParkACar(){
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        AttendentHelper attendentHelper = new AttendentHelper(parkingLots);
        attendentHelper.park(new Car("123456", Color.Green));
        assertTrue(parkingLots.get(0).isFull());
    }

    @Test
    public void expectsToThrowAnExceptionWhenParkingLotIsFullAndTryingToPark(){

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        AttendentHelper attendentHelper = new AttendentHelper(parkingLots);
        attendentHelper.park(new Car("123456", Color.Green));
        IllegalStateException thrown = assertThrows(IllegalStateException.class, ()->{
            attendentHelper.park(new Car("96378",Color.Red));
        });

        assertEquals("Sorry, can't park at the moment parking lot is full", thrown.getMessage());

    }

    @Test
    public void expectsToUnparkWhenGivenCorrectToken(){

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        AttendentHelper attendentHelper = new AttendentHelper(parkingLots);
        Token token = attendentHelper.park(new Car("123456", Color.Green));
        attendentHelper.unpark(token);
        assertFalse(parkingLots.get(0).isFull());

    }

    @Test
    public void expectsToThrowExceptionWhenGivenInCorrectTokenToUnpark(){

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        AttendentHelper attendentHelper = new AttendentHelper(parkingLots);
        Token token = attendentHelper.park(new Car("123456", Color.Green));
        Token randomToken = new Token();
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            attendentHelper.unpark(randomToken);
        });
        assertEquals("Invalid token Given...", thrown.getMessage());

    }


}
