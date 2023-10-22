package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;

import java.util.ArrayList;
import java.util.List;

public class ListEmployees {

    public List<Employee> addEmployee() {

        List<Employee> employees = new ArrayList<>();

        Employee jim = new Employee("Jim", EmployeeRole.HELPER);
        Employee bill = new Employee("Bill", EmployeeRole.HELPER);
        Employee jack = new Employee("Jack", EmployeeRole.HELPER);
        Employee nick = new Employee("Nick", EmployeeRole.HELPER);
        Employee roy = new Employee("Roy", EmployeeRole.HELPER);
        Employee bob = new Employee("Bob", EmployeeRole.HELPER);
        Employee billy = new Employee("Billy", EmployeeRole.HELPER);
        Employee tom = new Employee("Tom", EmployeeRole.HELPER);
        Employee jessy = new Employee("Jessy", EmployeeRole.HELPER);
        Employee mel = new Employee("Mel", EmployeeRole.HELPER);
        Employee fill = new Employee("Fill", EmployeeRole.HELPER);
        Employee garry = new Employee("Garry", EmployeeRole.HELPER);
        Employee derek = new Employee("Derek", EmployeeRole.ORGANIZER);
        Employee kirk = new Employee("Kirk", EmployeeRole.ORGANIZER);
        Employee noa = new Employee("Noa", EmployeeRole.ORGANIZER);
        Employee dug = new Employee("Dug", EmployeeRole.ORGANIZER);
        Employee bobo = new Employee("Bobo", EmployeeRole.ORGANIZER);

        employees.add(jim);
        employees.add(bill);
        employees.add(jack);
        employees.add(nick);
        employees.add(roy);
        employees.add(bob);
        employees.add(billy);
        employees.add(tom);
        employees.add(jessy);
        employees.add(mel);
        employees.add(fill);
        employees.add(derek);
        employees.add(kirk);
        employees.add(noa);
        employees.add(dug);
        employees.add(garry);
        employees.add(bobo);

        return employees;
    }
}
