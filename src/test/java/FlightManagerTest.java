import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private Pilot pilot1;
    private Pilot pilot2;
    private CabinCrewMember cabinCrewMember1;
    private CabinCrewMember cabinCrewMember2;
    private CabinCrewMember cabinCrewMember3;
    private CabinCrewMember cabinCrewMember4;
    private Plane plane;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;
    private Passenger passenger4;
    private Flight flight;
    private FlightManager flightManager;

    @Before
    public void before() {
        pilot1 = new Pilot("Jeff Jones", PilotType.CAPTAIN, "92HUR32");
        pilot2 = new Pilot("Steve Thompson", PilotType.FIRST_OFFICER, "29CNO32");
        ArrayList<Pilot> pilots = new ArrayList<>();
        pilots.add(pilot1);
        pilots.add(pilot2);
        cabinCrewMember1 = new CabinCrewMember("Bob Smith", CrewType.ATTENDANT);
        cabinCrewMember2 = new CabinCrewMember("Felix Jeffries", CrewType.MEDIC);
        cabinCrewMember3 = new CabinCrewMember("Tim Johnson", CrewType.ATTENDANT);
        cabinCrewMember4 = new CabinCrewMember("Fredrick Jefferson", CrewType.PURSER);
        ArrayList<CabinCrewMember> cabinCrewMembers = new ArrayList<>();
        cabinCrewMembers.add(cabinCrewMember1);
        cabinCrewMembers.add(cabinCrewMember2);
        cabinCrewMembers.add(cabinCrewMember3);
        cabinCrewMembers.add(cabinCrewMember4);
        plane = new Plane(PlaneType.AIRBUSA320);
        LocalDateTime departureTime = LocalDateTime.of(2022, 1, 7, 15, 0, 0);
        flight = new Flight(pilots, cabinCrewMembers, plane, "4BDIA8765", AirportLocation.LDN, AirportLocation.EDI, departureTime);
        passenger1 = new Passenger("Ted Jones", 2);
        passenger2 = new Passenger("Jones Smith", 2);
        passenger3 = new Passenger("Tim Duncan", 3);
        passenger4 = new Passenger("Ollie Fredrick", 1);
        flightManager = new FlightManager();
    }

    @Test
    public void canGetBaggageWeightPerPerson() {
        assertEquals(13, flightManager.calculateBaggageWeightPerPerson(flight));
    }

    @Test
    public void canGetCurrentBackageWeightOfPassengers() throws NoSuchAlgorithmException {
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        flight.bookPassenger(passenger4);
        assertEquals(32, flightManager.calculateCurrentBaggageWeightOfPassengers(flight));
    }

    @Test
    public void canGetRemainingBaggageWeightCapacity() throws NoSuchAlgorithmException {
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        flight.bookPassenger(passenger4);
        assertEquals(2308, flightManager.calculateRemainingBaggageWeightCapacity(flight));
    }

}
