package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;


import java.util.List;

public class Wedding extends Event {
    private boolean isCake;

    public Wedding(List<Employee> employees, boolean isCake) {
        super(EventType.WEDDING, employees);
        this.isCake = isCake;
    }

    public boolean hasCake() {
        return isCake;
    }
}
