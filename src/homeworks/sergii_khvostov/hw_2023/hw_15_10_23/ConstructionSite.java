package homeworks.sergii_khvostov.hw_2023.hw_15_10_23;

import java.util.ArrayList;
import java.util.List;

public class ConstructionSite {
    private ConstructionType type;
    private List<Employee> employees;

    public ConstructionSite(ConstructionType type) {
        this.type = type;
        employees = new ArrayList<>();
    }

    public ConstructionType getType() {
        return type;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean hasEngineer() {
        return employees.stream()
                .anyMatch(employee -> employee.getPosition() == EmployeePosition.ENGINEER);
    }
}
