package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

public abstract class Employee {
    private int currentId = 0;
    private int id;
    private String name;

    public abstract float calculateSalary(int hoursNumber);

    public Employee(String name) {
        this.id = this.currentId;
        this.currentId++;
        this.name = name;
    }
}
