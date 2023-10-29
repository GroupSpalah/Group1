package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;


import java.util.List;

public class Wedding extends Event {
    private boolean isCake;
    private long helperCount;
    private long organizerCount;

    public Wedding(EventType type, List<Employee> employees, boolean isCake,
                   long helperCount, long organizerCount) {
        super(type, employees);
        this.isCake = isCake;
        this.helperCount = helperCount;
        this.organizerCount = organizerCount;
        addEvent();
    }

    public boolean hasCake() {
        return isCake;
    }

    @Override
    public boolean canEventStart() {
        return helperCount >= 10 && organizerCount >= 3 && hasCake();
    }
}
