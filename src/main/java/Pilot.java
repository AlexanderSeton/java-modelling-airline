public class Pilot {

    private String name;
    private PilotType rank;
    private String pilotLicenseNumber;

    public Pilot(String name, PilotType rank, String pilotLicenseNumber) {
        this.name = name;
        this.rank = rank;
        this.pilotLicenseNumber = pilotLicenseNumber;
    }

    public String getName() {
        return this.name;
    }

    public PilotType getRank() {
        return this.rank;
    }

    public String getPilotLicenseNumber() {
        return this.pilotLicenseNumber;
    }

    public String getFullRank() {
        return this.rank.getFullRank();
    }

    public String flyPlane() {
        return this.getFullRank() + " " + this.getName() + " is flying the plane.";
    }

}
