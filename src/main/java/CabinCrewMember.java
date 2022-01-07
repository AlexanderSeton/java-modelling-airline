public class CabinCrewMember {

    private String name;
    private CrewType rank;

    public CabinCrewMember(String name, CrewType rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return this.name;
    }

    public CrewType getRank() {
        return this.rank;
    }

    public String getEnumValue() {
        return this.rank.getLabel();
    }

}
