public enum PilotType {

    CAPTAIN("captain"),
    SENIOR_FIRST_OFFICER("senior first officer"),
    FIRST_OFFICER("first officer"),
    SECOND_OFFICER("second_officer");

    private final String fullRank;

    PilotType(String fullRank) {
        this.fullRank = fullRank;
    }

    public String getFullRank() {
        return this.fullRank;
    }

}
