package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;

import java.util.List;

public class Conference extends Event {
    private boolean isBag;

    public Conference(List<Employee> employee, boolean isBag) {
        super(EventType.CONFERENCE, employee);
        this.isBag = isBag;
    }

    public boolean hasBag() {
        return isBag;
    }
}
