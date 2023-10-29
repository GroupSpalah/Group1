package homeworks.dmytro_k.hw_2023.hw_15_10_23;

public enum EmployeeType {
    WORKER(408, 6),
    SUPERVISOR(788, 5),
    ENGINEER(700, 40);

    private float baseSalary;
    private float hourSalary;

    EmployeeType(float baseSalary, float hourSalary) {
        this.baseSalary = baseSalary;
        this.hourSalary = hourSalary;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public float getHourSalary() {
        return hourSalary;
    }
}
