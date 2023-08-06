package lessons.collections.employee;

import java.time.Year;

/**
 * Implement method `getSalaryInfo(String name, int yearFrom, int yearTo)`.
 * It should calculate salary for employees.
 *
 * Пример:
 *
 * Имена:
 * ```
 *    John
 *    Andrew
 *    Kate
 * ```
 *
 * Статистика:
 * ```
 *   2019 John   450
 *   2020 Andrew 3200
 *   2018 John   7100
 *   2021 Kate   9100
 *   2022 John   1150
 *   2014 Andrew 3150
 *   2015 John   7100
 *   2013 Kate   9100
 * ```
 *
 * Method execution result:
 * ```
 *    Report for period 2015  - 2022
 *    John - 8700
 *    Andrew - 6350
 *    Kate - 18200
 * ```
 */
public class TestEmployee {
    public static void main(String[] args) {
        Year year2015 = Year.of(2015);
        Year year2020 = Year.of(2020);

        YearSalary ys1 = new YearSalary(year2015, 1200);
        YearSalary ys2 = new YearSalary(Year.of(2017), 1500);
        YearSalary ys3 = new YearSalary(Year.of(2019), 1700);

        Person john = new Person("John");

        john.addSalary(ys2);
        john.addSalary(ys1);
        john.addSalary(ys3);

        PersonService service = new PersonService();

        service.addPerson(john);

        float salary = service.getSalaryInfo("John", year2015, year2020);

        System.out.println(salary);
    }
}
