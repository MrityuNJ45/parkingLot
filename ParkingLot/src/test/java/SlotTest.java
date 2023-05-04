import static org.junit.Assert.*;

import org.example.Car;
import org.example.Color;
import org.example.Slot;
import org.junit.Test;

public class SlotTest {

    @Test
    public void expectsSlotIsCreatedOrNot(){

        Slot slot = new Slot(1);
        assertTrue(slot instanceof Slot);

    }

    @Test
    public void expectsFalseWhenCarIsAllocatedToSlot(){

        Car car = new Car("123456", Color.Black);
        Slot slot = new Slot(1);

        slot.park(car);
        assertTrue(!slot.isEmpty());


    }

    @Test
    public void expectsFalseWhenCarIsPresentInSlot(){

        Slot slot = new Slot(1);
        Car car = new Car("789456", Color.Black);
        //slot.parkCarInSlot(car);
//        assertEquals();
        System.out.println(slot.isEmpty());

    }


    @Test
    public void expectsTrueIfColorOfCarPresent(){

        Car car = new Car("123456", Color.Black);
        Slot slot = new Slot(1);
        slot.park(car);
        assertTrue(slot.isColorOfCarPresent(Color.Black));


    }

    @Test
    public void expectsToThrowExceptionWhenInvalidCarDetailsAreThrown(){

        Car car = new Car("456123", Color.Blue);
        Slot slot = new Slot(1);
        slot.park(car);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            slot.unpark(new Car("7894561", Color.Blue));});

        assertEquals("Invalid Car details...", thrown.getMessage());

    }

    @Test
    public void expectsToEmptySlotByUnparking(){

        Car car = new Car("456123", Color.Blue);
        Slot slot = new Slot(1);
        slot.park(car);
        slot.unpark(car);
        assertTrue(slot.isEmpty());


    }


    @Test
    public void expectsTrueWhenCarIsPresentInSlot(){

        Slot slot = new Slot(1);
        slot.park(new Car("0987", Color.Red));
        assertTrue(slot.particularCarPresentOrNot(new Car("0987", Color.Red)));

    }


}
