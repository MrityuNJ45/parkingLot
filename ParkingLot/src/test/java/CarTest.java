import org.example.Car;
import org.example.Color;
import static org.junit.Assert.*;
import org.junit.Test;

public class CarTest {


    @Test
    public void expectsCarIsCreatedOrNot(){

        Car aCar = new Car("123456", Color.Black);
        assertEquals(true, aCar instanceof Car);

    }


    @Test
    public void expectsTrueIfCorrectColoredIsChecked(){

        Car aCar = new Car("123456", Color.Black);
        assertEquals(true,aCar.isOfColor(Color.Black));



    }

   


}
