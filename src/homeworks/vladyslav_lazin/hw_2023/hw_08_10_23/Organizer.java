package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;

public final class Organizer extends Employee {
    private int mainOrganizerEventCount;
    public Organizer(String name, int mainOrganizerEventCount) {
        super(name);
        this.mainOrganizerEventCount = mainOrganizerEventCount;
    }

    public int getMainOrganizerEventCount() {
        return mainOrganizerEventCount;
    }

    public void setMainOrganizerEventCount(int mainOrganizerEventCount) {
        this.mainOrganizerEventCount = mainOrganizerEventCount;
    }
}
