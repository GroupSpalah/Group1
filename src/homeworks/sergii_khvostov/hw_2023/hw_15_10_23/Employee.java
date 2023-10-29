package homeworks.sergii_khvostov.hw_2023.hw_15_10_23;

public class Employee {
    private String name;
    private int id;
    private EmployeePosition position;
    private int hoursWorked;

    private boolean isFullDay;

    public Employee(String name, int id, EmployeePosition position, int hoursWorked) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.hoursWorked = hoursWorked;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }
}
