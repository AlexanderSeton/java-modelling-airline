import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CabinCrewMemberTest {

    private CabinCrewMember cabinCrewMember;

    @Before
    public void before() {
        cabinCrewMember = new CabinCrewMember("Philip Smith", CrewType.ENGINEER);
    }

    @Test
    public void hasName() {
        assertEquals("Philip Smith", cabinCrewMember.getName());
    }

    @Test
    public void hasRank() {
        assertEquals(CrewType.ENGINEER, cabinCrewMember.getRank());
    }

    @Test
    public void hasFullRank() {
        assertEquals("flight engineer", cabinCrewMember.getEnumValue());
    }

}
