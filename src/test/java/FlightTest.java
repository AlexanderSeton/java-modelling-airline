import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
        LocalDateTime departureTime = LocalDateTime.of(2022, 1, 7, 15, 0, 0);
        flight = new Flight(pilots, cabinCrewMembers, plane, "4BDIA8765", AirportLocation.LDN, AirportLocation.EDI, departureTime);
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
        LocalDateTime departureTime = LocalDateTime.of(2022, 1, 7, 15, 0, 0);
        assertEquals(departureTime, flight.getDepartureTime());
    }

    @Test
    public void hasPassengers() {
        ArrayList<Passenger> passengers = new ArrayList<>();
        assertEquals(passengers, flight.getPassengers());
    }

    @Test
    public void canReturnNumberOfAvailableSeats() {
        assertEquals(180, flight.getNumberAvailableSeats());
    }

    @Test
    public void canBookAPassengerInWhenSpace() throws NoSuchAlgorithmException {
        flight.bookPassenger(passenger1);
        assertEquals(179, flight.getNumberAvailableSeats());
        assertEquals(1, flight.getPassengers().size());
    }

    @Test
    public void canNotBookPassengerInWhenNoSpace() throws NoSuchAlgorithmException {
        for (int i=0; i<180; i++) {
            flight.bookPassenger(passenger2);
        }
        assertEquals(180, flight.getPassengers().size());
        assertEquals(0, flight.getNumberAvailableSeats());
    }

    @Test
    public void passengerFlightStatusSetToTrueWhenBookedOntoPlane() throws NoSuchAlgorithmException {
        assertEquals(false, passenger1.getOnFlight());
        flight.bookPassenger(passenger1);
        assertEquals(true, passenger1.getOnFlight());
    }

    @Test
    public void passengerSeatNumberSetAfterBooking() throws NoSuchAlgorithmException {
        assertEquals(null, passenger1.getSeatNumber());
        flight.bookPassenger(passenger1);
        assertFalse(passenger1.getSeatNumber() == null);
    }

}
