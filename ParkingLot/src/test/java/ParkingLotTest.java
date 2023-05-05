import org.example.Car;
import org.example.Color;
import org.example.ParkingLot;
import static org.junit.Assert.*;

import org.example.Token;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void expectsParkingLotToBeCreated(){

        ParkingLot parkingLot = new ParkingLot(2);
        assertTrue(parkingLot instanceof ParkingLot);


    }



    @Test
    public void expectsFalseWhenCheckingForParkingLotFullOrNotInitially(){
        ParkingLot parkingLot = new ParkingLot(1);
        assertEquals(Boolean.valueOf(false),parkingLot.isFull());
    }

    @Test
    public void expectsToAddCarInEmptySlot(){
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car("456123", Color.Green);
        parkingLot.addCarToEmptySlot(car);
        assertEquals(Integer.valueOf(1), parkingLot.getNumberOfEmptySlots());
    }


    @Test
    public void expectsToThrowExceptionWhenCarIsNotThereAndTryingToUnpark(){

        // TODO :
        ParkingLot parkingLot = new ParkingLot(1);
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            parkingLot.unparkFromParkingLot(new Token());
        });
        assertEquals("Car not found", thrown.getMessage());
    }



    @Test
    public void expectsNumberOfCarsPresentOfParticularColor(){
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.addCarToEmptySlot(new Car("123456", Color.Green));
        parkingLot.addCarToEmptySlot(new Car("123sdf6", Color.Green));
        parkingLot.addCarToEmptySlot(new Car("1234dfs", Color.Red));
        Integer ans = parkingLot.numberOfCarsOfColor(Color.Green);
        assertEquals(Integer.valueOf(2), ans);
    }


}
