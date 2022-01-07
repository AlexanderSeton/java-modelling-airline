public enum PlaneType {

    BOEING747(467, 200000, 439000, 147000),
    AIRBUSA320(180, 42100, 77000, 15850);

    private final int capacity;
    private final int weight;
    private final int maxWeight;
    private final int fuelWeight;

    PlaneType(int capacity, int weight, int maxWeight, int fuelWeight) {
        this.capacity = capacity;
        this.weight = weight;
        this.maxWeight = maxWeight;
        this.fuelWeight = fuelWeight;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getMaxWeight() {
        return this.maxWeight;
    }

    public int getFuelWeight() {
        return this.fuelWeight;
    }

}
