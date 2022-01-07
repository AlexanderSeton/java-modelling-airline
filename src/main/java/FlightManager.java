public class FlightManager {

    public int calculateBaggageWeightPerPerson(Flight flight) {
        int spareWeightCapacity = flight.getPlane().getPlaneWeightCapacity();
        // use 95% of spare capacity
        spareWeightCapacity *= 0.95;
        int passengerCapacity = flight.getPlane().getPlaneCapacity();
        // assume all passengers & staff weigh 80kg
        int allPassengersWeight = passengerCapacity * 80;
        int numberOfStaff = flight.getCabinCrew().size() + flight.getPilots().size();
        int allStaffWeight = numberOfStaff * 80;
        int fuelWeight = flight.getPlane().getPlaneFuelWeight();
        int weightCapacityForBaggage = spareWeightCapacity - allPassengersWeight - allStaffWeight - fuelWeight;
        int weightForBaggagePerPassenger = weightCapacityForBaggage / passengerCapacity;
        return weightForBaggagePerPassenger;
    }

    public int calculateCurrentBaggageWeightOfPassengers(Flight flight) {
        // assuming 1 bag weighs 4kg
        int numberPassengers = flight.getPassengers().size();
        int numberBags = 0;
        for (int i=0; i<numberPassengers; i++) {
            numberBags += flight.getPassengers().get(i).getNumberBags();
        }
        int currentBaggageWeight = 4 * numberBags;
        return currentBaggageWeight;
    }

    public int calculateRemainingBaggageWeightCapacity(Flight flight) {
        int weightForBaggagePerPassenger = this.calculateBaggageWeightPerPerson(flight);
        int totalBaggageWeight = weightForBaggagePerPassenger * flight.getPlane().getPlaneCapacity();
        int remainingBaggageCapacity = totalBaggageWeight - this.calculateCurrentBaggageWeightOfPassengers(flight);
        return remainingBaggageCapacity;
    }

}
