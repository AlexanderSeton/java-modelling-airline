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
        assertEquals(200000, plane.getPlaneWeight());
    }

    @Test
    public void canGetPlaneMaxWeight() {
        assertEquals(439000, plane.getPlaneMaxWeight());
    }

    @Test
    public void canGetPlaneWeightCapacity() {
        assertEquals(239000, plane.getPlaneWeightCapacity());
    }

    @Test
    public void canGetPlaneFuelWeight() {
        assertEquals(147000, plane.getPlaneFuelWeight());
    }

}
