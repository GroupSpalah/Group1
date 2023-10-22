package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

public class FullTimeWorker extends Employee{
    private final int SALARY = 408;
    private final int HOURLY_RATE = 6;
    public FullTimeWorker(String name) {
        super(name);
    }
    @Override
    public float calculateSalary(int hoursNumber) {
        return SALARY + HOURLY_RATE * hoursNumber;
    }
}
