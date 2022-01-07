import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Pilot pilot;
    private CabinCrewMember cabinCrewMember1;
    private CabinCrewMember cabinCrewMember2;
    private Plane plane;
    private Passenger passenger1;
    private Passenger passenger2;
    private Flight flight;

    @Before
    public void before() {
        pilot = new Pilot("Jeff Jones", PilotType.CAPTAIN, "92HUR32");
        ArrayList<Pilot> pilots = new ArrayList<>();
        pilots.add(pilot);
        cabinCrewMember1 = new CabinCrewMember("Bob Smith", CrewType.ATTENDANT);
        cabinCrewMember2 = new CabinCrewMember("Felix Jeffries", CrewType.MEDIC);
        ArrayList<CabinCrewMember> cabinCrewMembers = new ArrayList<>();
        cabinCrewMembers.add(cabinCrewMember1);
        cabinCrewMembers.add(cabinCrewMember2);
        plane = new Plane(PlaneType.AIRBUSA320);
        flight = new Flight(pilots, cabinCrewMembers, plane, "4BDIA8765", AirportLocation.LDN, AirportLocation.EDI, "2022-01-07T13:00:00");
        passenger1 = new Passenger("Ted Jones", 2);
        passenger2 = new Passenger("Jones Smith", 1);
    }

    @Test
    public void hasPilots() {
        ArrayList<Pilot> pilots = new ArrayList<>();
        pilots.add(pilot);
        assertEquals(pilots, flight.getPilots());
    }

    @Test
    public void hasCabinCrew() {
        ArrayList<CabinCrewMember> cabinCrewMembers = new ArrayList<>();
        cabinCrewMembers.add(cabinCrewMember1);
        cabinCrewMembers.add(cabinCrewMember2);
        assertEquals(cabinCrewMembers, flight.getCabinCrew());
    }

    @Test
    public void hasPlane() {
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void hasFlightNumber() {
        assertEquals("4BDIA8765", flight.getFlightNumber());
    }

    @Test
    public void hasDestinationAirport() {
        assertEquals(AirportLocation.LDN, flight.getDestinationAirport());
    }

    @Test
    public void hasDepartureAirport() {
        assertEquals(AirportLocation.EDI, flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime() {
        assertEquals("2022-01-07T13:00:00", flight.getDepartureTime());
    }

    @Test
    public void hasPassengers() {
        ArrayList<Passenger> passengers = new ArrayList<>();
        assertEquals(passengers, flight.getPassengers());
    }

    @Test
    public void canReturnNumberOfAvailableSeats() {
        assertEquals(170, flight.getNumberAvailableSeats());
    }

    @Test
    public void canBookAPassengerInWhenSpace() {
        flight.bookPassenger(passenger1);
        assertEquals(169, flight.getNumberAvailableSeats());
        assertEquals(1, flight.getPassengers().size());
    }

    @Test
    public void canNotBookPassengerInWhenNoSpace() {
        for (int i=0; i<180; i++) {
            flight.bookPassenger(passenger2);
        }
        assertEquals(170, flight.getPassengers().size());
        assertEquals(0, flight.getNumberAvailableSeats());
    }

}
