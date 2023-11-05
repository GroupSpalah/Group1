package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;

import java.util.List;

public class ListEmployees {
    public static List<Employee> addEmployee() {
        return List.of(
                new Employee("Jim", EmployeeRole.HELPER),
                new Employee("Bill", EmployeeRole.HELPER),
                new Employee("Jack", EmployeeRole.HELPER),
                new Employee("Nick", EmployeeRole.HELPER),
                new Employee("Roy", EmployeeRole.HELPER),
                new Employee("Bob", EmployeeRole.HELPER),
                new Employee("Billy", EmployeeRole.HELPER),
                new Employee("Tom", EmployeeRole.HELPER),
                new Employee("Jessy", EmployeeRole.HELPER),
                new Employee("Mel", EmployeeRole.HELPER),
                new Employee("Fill", EmployeeRole.HELPER),
                new Employee("Garry", EmployeeRole.HELPER),
                new Employee("Derek", EmployeeRole.ORGANIZER),
                new Employee("Kirk", EmployeeRole.ORGANIZER),
                new Employee("Noa", EmployeeRole.ORGANIZER),
                new Employee("Dug", EmployeeRole.ORGANIZER),
                new Employee("Bobo", EmployeeRole.ORGANIZER));

    }
}
