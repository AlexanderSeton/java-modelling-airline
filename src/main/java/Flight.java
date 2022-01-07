import java.util.ArrayList;

public class Flight {

    private ArrayList<Pilot> pilots;
    private ArrayList<CabinCrewMember> cabinCrew;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private AirportLocation destinationAirport;
    private AirportLocation departureAirport;
    private String departureTime;

    public Flight(ArrayList<Pilot> pilots, ArrayList<CabinCrewMember> cabinCrew, Plane plane, String flightNumber, AirportLocation destinationAirport, AirportLocation departureAirport, String departureTime) {
        this.pilots = pilots;
        this.cabinCrew = cabinCrew;
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destinationAirport = destinationAirport;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
    }

    public ArrayList<Pilot> getPilots() {
        return this.pilots;
    }

    public ArrayList<CabinCrewMember> getCabinCrew() {
        return this.cabinCrew;
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public AirportLocation getDestinationAirport() {
        return this.destinationAirport;
    }

    public AirportLocation getDepartureAirport() {
        return this.departureAirport;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public int getNumberAvailableSeats() {
        return this.plane.getPlaneCapacity() - this.passengers.size();
    }

    public void bookPassenger(Passenger passenger) {
        if (this.getNumberAvailableSeats() >= 1) {
            this.passengers.add(passenger);
        }
    }

}
