package homeworks.sergii_khvostov.hw_2023.hw_15_10_23;

import java.util.ArrayList;
import java.util.List;

public class ListEmployees {
    public List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 1, EmployeePosition.WORKER, 40));
        employees.add(new Employee("Bill", 2, EmployeePosition.SUPERVISOR, 30));
        employees.add(new Employee("Jack", 3, EmployeePosition.ENGINEER, 50));
        employees.add(new Employee("Dan", 4, EmployeePosition.WORKER, 35));
        return employees;
    }
}
