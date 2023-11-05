package homeworks.sergii_khvostov.hw_2023.hw_15_10_23;

import java.util.List;

public class ListEmployees {
    public static List<Employee> createEmployees() {
        return List.of(
                new Employee("John", 1, EmployeePosition.WORKER, 40, true),
                new Employee("Bill", 2, EmployeePosition.SUPERVISOR, 30, true),
                new Employee("Jack", 3, EmployeePosition.ENGINEER, 50, true),
                new Employee("Dan", 4, EmployeePosition.WORKER, 35, false)
        );
    }
}
