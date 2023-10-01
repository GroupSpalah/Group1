package lessons.streams.dental.domain;

public class StaffRecord {
    private String name;
    private Specialisation specialisation;

    public StaffRecord(String name, Specialisation specialisation) {
        this.name = name;
        this.specialisation = specialisation;
    }

    public String getName() {
        return name;
    }

    public Specialisation getSpecialisation() {
        return specialisation;
    }

    @Override
    public String toString() {
        return "StaffRecord" + " name " + name +
                ", specialisation=" + specialisation;
    }
}
