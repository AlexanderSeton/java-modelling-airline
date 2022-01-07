import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class PassengerTest {

    private Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger("Tim Cook", 2);
    }

    @Test
    public void hasName() {
        assertEquals("Tim Cook", passenger.getName());
    }

    @Test
    public void hasNumberBags() {
        assertEquals(2, passenger.getNumberBags());
    }

}
