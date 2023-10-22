package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

public class SectionChief extends Employee {
    private final int SALARY = 700;
    private final int HOURLY_RATE = 40;
    public SectionChief(String name) {
        super(name);
    }

    @Override
    public float calculateSalary(int hoursNumber) {
        return SALARY + HOURLY_RATE * hoursNumber;
    }
}
