package homeworks.sergii_khvostov.hw_2023.hw_15_10_23;

import java.util.List;

public record ConstructionSite(ConstructionType type, List<Employee> employees) {
    public boolean hasEngineer() {
        return employees.stream()
                .anyMatch(employee -> employee.position() == EmployeePosition.ENGINEER);
    }
}
