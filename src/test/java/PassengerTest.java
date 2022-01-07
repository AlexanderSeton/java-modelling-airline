import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

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

    @Test
    public void hasOnFlight() {
        assertEquals(false, passenger.getOnFlight());
    }

    @Test
    public void hasSeatNumber() {
        assertEquals(null, passenger.getSeatNumber());
    }

    @Test
    public void canHash() throws NoSuchAlgorithmException {
        assertEquals("d95455ab1064993fd521632cff4541cb78efe9bf60bd4636daf5d3dca9f1532f", passenger.generateHash());
    }

}
