package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

public class SuperViser extends Employee{
    private final int subordinatesNumber;
    private final int SALARY = 788;
    private final int HOURLY_RATE = 5;
    public SuperViser(String name, int subordinatesNumber) {
        super(name);
        this.subordinatesNumber = subordinatesNumber;
    }

    @Override
    public float calculateSalary(int hoursNumber) {
        return (float) (SALARY + hoursNumber * HOURLY_RATE + this.subordinatesNumber * .5);
    }
}
