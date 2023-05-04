import org.example.Car;
import org.example.Color;
import org.example.Floor;
import static org.junit.Assert.*;
import org.junit.Test;

public class FloorTest {


    @Test
    public void expectsFloorTobeCreated(){

        Floor floor = new Floor(2,3);
        assertTrue(floor instanceof Floor);


    }

    @Test
    public void expectsToReturnFalseWhenFloorHasEmptySlots(){

        Floor floor = new Floor(1,2);
        assertFalse(floor.ifFloorIsFull());


    }

    @Test
    public void expectsToReturnTrueWhenFloorIsFull(){

        Floor floor = new Floor(1,2);



    }

    @Test
    public void expecsToAddCarInEmptySlotInAFloor(){

        Floor floor = new Floor(1,2);
        Car car = new Car("456123", Color.Black);

        floor.addCarToEmptySlot(car);

       assertEquals(Integer.valueOf(1), floor.getNoOfEmptySlots());

    }

    @Test
    public void expectsToThrowExceptionWhenGivingInvalidCarDetails(){

        Floor floor = new Floor(1, 1);
        Car car = new Car("12345", Color.Red);
        floor.addCarToEmptySlot(car);
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () ->{
            floor.unparkFromFloor(new Car("78945",Color.Red));
        });

        assertEquals("Car not found...", thrown.getMessage());

    }




}
