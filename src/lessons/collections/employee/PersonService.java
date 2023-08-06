package lessons.collections.employee;

import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonService {
    private List<Person> people;

    public PersonService() {
        people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public float getSalaryInfo(String name, Year from, Year to) {
        Iterator<Person> pIterator = people.iterator();

        float sum = 0;

        while (pIterator.hasNext()) {
            Person person = pIterator.next();

            String personName = person.getName();

            if (personName.equals(name)) {
                List<YearSalary> salaries = person.getSalaries();

                Iterator<YearSalary> sIterator = salaries.iterator();

                while (sIterator.hasNext()) {
                    YearSalary ys = sIterator.next();

                    int valueFrom = from.getValue();
                    int valueTo = to.getValue();
                    int value = ys.getYear().getValue();

                    if (value >= valueFrom && value <= valueTo) {
                        sum += ys.getSalary();
                    }
                }
            }
        }

        return sum;
    }
}
