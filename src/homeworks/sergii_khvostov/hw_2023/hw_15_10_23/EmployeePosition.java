package homeworks.sergii_khvostov.hw_2023.hw_15_10_23;


import java.math.BigDecimal;

public enum EmployeePosition {
    WORKER(408, 6),
    SUPERVISOR(788, 5),
    ENGINEER(700, 40);

    private final BigDecimal baseSalary;
    private final BigDecimal hourlyRate;

    EmployeePosition(int baseSalary, int hourlyRate) {
        this.baseSalary = new BigDecimal(baseSalary);
        this.hourlyRate = new BigDecimal(hourlyRate);
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }
}
