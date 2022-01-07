public enum CrewType {

    ATTENDANT("flight attendant"),
    ENGINEER("flight engineer"),
    MEDIC("flight medic"),
    PURSER("chief flight attendant"),
    NAVIGATOR("flight navigator");

    private final String label;

    CrewType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

}
