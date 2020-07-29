import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.*;

public class UnitTest {
    private String mFirstValue="eat";
    private String mSecondValue="tar";

    @Test
    public void testIsAnagramOrNot() {
        Anagram anagramTest  = new Anagram();
        Boolean result = anagramTest.anagramCheck(mFirstValue, mSecondValue);
        if(result){
            assertEquals(mFirstValue+" and "+mSecondValue+" are Anagram");
        }
        else{
            assertEquals(mFirstValue+" and "+mSecondValue+" are not Anagram");
        }
    }

    @Test
    public void testIsInputValid() {
        Anagram  anagramTest = new Anagram();
        if(mFirstValue!=null && mSecondValue!=null){
            System.out.println("inputs are valid");
        }
        else{
            System.out.println("inputs are not valid");
        }

    }

    @Test
    public void testCarUsingAbstractFactoryPatternSuccessCase() {
        int numOfWheels = 4;
        int numOfPassengers = 5;
        boolean hasGas = false;

        Vehicle.CarUsingBuilderPatten car = new Vehicle.CarUsingBuilderPatten.Builder().withTotalWheels(numOfWheels).withPassengerMaxCapacity(numOfPassengers)
                .withGasEngine(hasGas).build();


        assertEquals(numOfWheels, car.getNumOfWheels());
        assertEquals(numOfPassengers, car.getNumOfPassengers());
        assertEquals(hasGas, car.hasGas());

    }

    @Test
    public void testPlaneUsingAbstractFactoryPatternSuccessCase() {
        int numOfWheels = 18;
        int numOfPassengers = 200;
        boolean hasGas = true;

        Vehicl.PlaneUsingBuilderPatten plane = new Vehicle.laneUsingBuilderPatten.Builder().withTotalWheels(numOfWheels)
                .withPassengerMaxCapacity(numOfPassengers).withGasEngine(true).build();

        assertEquals(numOfWheels, plane.getNumOfWheels());
        assertEquals(numOfPassengers, plane.getNumOfPassengers());
        assertEquals(hasGas, plane.hasGas());
    }

    @Test
    public void testCarUsingAbstractFactoryPatternFailCase() {
        int numOfWheels = 4;
        int numOfPassengers = 5;
        boolean hasGas = false;

        Vehicle.CarUsingBuilderPatten car = new Vehicle.CarUsingBuilderPatten.Builder().withTotalWheels(4).withPassengerMaxCapacity(5)
                .withGasEngine(false).build();

        assertNotEquals(50, car.getNumOfWheels());
        assertNotEquals(20, car.getNumOfPassengers());
        assertNotEquals(true, car.hasGas());
    }

    @Test
    public void testPlaneUsingBuAbstractFactoryPatternFailCase() {
        int numOfWheels = 18;
        int numOfPassengers = 200;
        boolean hasGas = true;

        Vehicle.PlaneUsingBuilderPatten plane = new Vehicle.PlaneUsingBuilderPatten.Builder().withTotalWheels(18)
                .withPassengerMaxCapacity(200).withGasEngine(true).build();

        assertNotEquals(50, plane.getNumOfWheels());
        assertNotEquals(20, plane.getNumOfPassengers());
        assertNotEquals(false, plane.hasGas());
    }

    @Test
    public void testForward() {
        VideoPlayer videoPlayer = new VideoPlayer();
        assertEquals(true, videoPlayer.forward(10));
    }

    @Test
    public void testRewind() {
        VideoPlayer videoPlayer = new VideoPlayer();
        assertEquals(true, videoPlayer.rewind());
    }

    @Test
    public void testPlay() {
        VideoPlayer videoPlayer = new VideoPlayer();
        assertEquals(true, videoPlayer.play());
    }
}
