package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

public class PartTimeWorker extends Employee {
    private final int HOURLY_RATE = 6;
    public PartTimeWorker(String name) {
        super(name);
    }

    @Override
    public float calculateSalary(int hoursNumber) {
        return 2 * HOURLY_RATE * hoursNumber;
    }
}
