import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {

    private Pilot pilot;

    @Before
    public void before() {
        pilot = new Pilot("Bill Jones", PilotType.CAPTAIN, "DNAOI32U8923N");
    }

    @Test
    public void hasName() {
        assertEquals("Bill Jones", pilot.getName());
    }

    @Test
    public void hasRank() {
        assertEquals(PilotType.CAPTAIN, pilot.getRank());
    }

    @Test
    public void hasPilotLicenseNumber() {
        assertEquals("DNAOI32U8923N", pilot.getPilotLicenseNumber());
    }

    @Test
    public void hasFullRank() {
        assertEquals("captain", pilot.getFullRank());
    }

}
