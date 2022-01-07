import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING747);
    }

    @Test
    public void hasPlaneType() {
        assertEquals(PlaneType.BOEING747, plane.getPlaneType());
    }

    @Test
    public void canGetPlaneCapacity() {
        assertEquals(467, plane.getPlaneCapacity());
    }

    @Test
    public void canGetPlaneWeight() {
        assertEquals(183500, plane.getPlaneWeight());
    }

}
