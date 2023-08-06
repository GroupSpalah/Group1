package lessons.collections.employee;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<YearSalary> salaries;

    public Person(String name) {
        this.name = name;
        salaries = new ArrayList<>();
    }

    public void addSalary(YearSalary yearSalary) {
        salaries.add(yearSalary);
    }

    public String getName() {
        return name;
    }

    public List<YearSalary> getSalaries() {
        return salaries;
    }
}
