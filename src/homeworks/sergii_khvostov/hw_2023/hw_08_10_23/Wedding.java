package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;


public class Wedding extends Event {
    private boolean isCake;

    public Wedding() {
        super(EventType.WEDDING);
        this.isCake = isCake();
    }

    public boolean isCake() {
        return isCake;
    }

    @Override
    public boolean canEventStart() {
        long helper = getEmployees().stream()
                .filter(employee -> employee.role() == EmployeeRole.HELPER)
                .count();
        long organizer = getEmployees().stream()
                .filter(employee -> employee.role() == EmployeeRole.ORGANIZER)
                .count();
        return helper >= 10 && organizer >= 3 && isCake();
    }
}
