public class Plane {

    private PlaneType planeType;

    public Plane(PlaneType planeType) {
        this.planeType = planeType;
    }

    public PlaneType getPlaneType() {
        return this.planeType;
    }

    public int getPlaneCapacity() {
        return this.planeType.getCapacity();
    }

    public int getPlaneWeight() {
        return this.planeType.getWeight();
    }

    public int getPlaneMaxWeight() {
        return this.planeType.getMaxWeight();
    }

    public int getPlaneWeightCapacity() {
        return this.getPlaneMaxWeight() - this.getPlaneWeight();
    }

    public int getPlaneFuelWeight() {
        return this.planeType.getFuelWeight();
    }

}
