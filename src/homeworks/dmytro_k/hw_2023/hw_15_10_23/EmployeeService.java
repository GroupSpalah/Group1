package homeworks.dmytro_k.hw_2023.hw_15_10_23;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public int employeesCount() {
        return employees.size();
    }

}
