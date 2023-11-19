package homeworks.dmytro_k.hw_2023.hw_15_10_23;

/*
 * 3) Строительная компания хочет улучшить свою внутреннюю практику, внедрив новую цифровую систему.
 * <p>
 * Первый модуль приложения — управление сотрудниками. У сотрудника есть имя, идентификатор сотрудника,
 * а также должность: рабочий, супервайзер, инженер. Работники могут работать как на окладе,
 * так и на условиях неполного рабочего времени. Работники получают заработную плату в
 * деньгах на основе следующих правил:
 * <p>
 * Рабочие получают базовую заработную плату в размере 408$ и 6$ за отработанные часы.
 * <p>
 * Супервайзеры получают базовую зарплату в размере 788$, 5$ в час
 * плюс 0,5$ за каждого рабочего, которого они контролируют.
 * <p>
 * Инженеры получают базовую оплату в размере 700$ и 40$ в час.
 * Работники, занятые неполный рабочий день, не получают
 * базовую заработную плату, но получают двойную почасовую ставку по найму.
 * <p>
 * Следующий модуль приложения — управление ходом строительных площадок. Существуют различные
 * типы строительных площадок(по количеству часов постройки):
 * ++ жилые дома(10000), многоквартирные дома(1000000) и офисные здания(2000000).
 * ++ На каждой строительной площадке есть список ответственных за нее сотрудников.
 * ++Прогресс на стройке начинается только в том случае,
 * если один из сотрудников является инженером.
 * ++Наконец, для отчетности компания хочет знать,
 * каково среднее количество рабочих на строительной площадке офисного здания.
 * Посчитать общую сумму зарплат всем рабочим.
 *
 * Наконец, для отчетности компания хочет знать,
 * каково среднее количество рабочих на строительной площадке офисного здания.
 * Посчитать общую сумму зарплат всем рабочим. Присутствует инженер
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructionSiteService {
    private final List<ConstructionSite> constructionSites;

    public ConstructionSiteService() {
        constructionSites = new ArrayList<>();
    }

    public void addConstructionSite(ConstructionSite constructionSite) {
        constructionSites.add(constructionSite);
    }

    public Predicate<Employee> employeePredicate(EmployeeType employeeType) {

        if (employeeType.equals(EmployeeType.WORKER)) {
            return employee -> employee
                    .getEmployeeType()
                    .equals(EmployeeType.WORKER);
        } else if (employeeType.equals(EmployeeType.ENGINEER)) {
            return employee -> employee
                    .getEmployeeType()
                    .equals(EmployeeType.ENGINEER);
        } else {
            return employee -> employee
                    .getEmployeeType()
                    .equals(EmployeeType.SUPERVISOR);
        }
    }

    public Predicate<ConstructionSite> constructionSitePredicate(ConstructionSiteType constructionSiteType) {

        if (constructionSiteType.equals(ConstructionSiteType.OFFICE_BUILDING)) {
            return constructionSite -> constructionSite
                    .getConstructionSiteType()
                    .equals(ConstructionSiteType.OFFICE_BUILDING);
        } else if (constructionSiteType.equals(ConstructionSiteType.APARTMENT_BUILDING)) {
            return constructionSite -> constructionSite
                    .getConstructionSiteType()
                    .equals(ConstructionSiteType.APARTMENT_BUILDING);
        } else {
            return constructionSite -> constructionSite
                    .getConstructionSiteType()
                    .equals(ConstructionSiteType.RESIDENTIAL_BUILDING);
        }
    }

    public Stream<Employee> employeeStream(EmployeeType employeeType) {//privat?
        return constructionSites
                .stream()
                .flatMap(constructionSite -> constructionSite
                        .getEmployees()
                        .stream()
                        .filter(employeePredicate(employeeType)));
    }

    public void getAverageNumberOfficeBuildingEmployees2() {

        int officeBuildingCount = constructionSites
                .stream()
                .filter(constructionSitePredicate(ConstructionSiteType.OFFICE_BUILDING))
                .collect(Collectors.toSet())
                .size();

        double workerSum = constructionSites
                .stream()
                .filter(constructionSitePredicate(ConstructionSiteType.OFFICE_BUILDING))
                .toList()
                .stream()
                .mapToDouble(constructionSites -> constructionSites
                        .getEmployees()
                        .stream()
                        .filter(employeePredicate(EmployeeType.WORKER))
                        .count())
                .sum();

        System.out.println("Average number of employees for an office building2: " + workerSum / officeBuildingCount);
    }

    public double employeeCount(EmployeeType employeeType) {//для рассчета зп супервизера?

        double employeeCount = employeeStream(employeeType)
                .collect(Collectors.toSet())
                .size();

        System.out.println(employeeCount + "WK");//для проверки
        return employeeCount;
    }

    public double sumSalary(EmployeeType employeeType) {//need finish.

        return employeeStream(employeeType)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public double sumSalaries(EmployeeType employeeType) {//доделать. has engineer

        int workers = employeeStream(EmployeeType.WORKER)
                .collect(Collectors.toSet())
                .size();//все рабочие, а не подконтрольные, переделать (двойной поток?)

        if (employeeType.equals(EmployeeType.SUPERVISOR)) {
            return employeeStream(employeeType)
                    .mapToDouble(Employee::getSalary)
                    .sum() + (workers * 0.5);
        }

        return employeeStream(employeeType)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public double sumSalariesFull(EmployeeType employeeType) {

        int workers = constructionSites
                .stream()
                .flatMap(constructionSite -> constructionSite
                        .getEmployees()
                        .stream()
                        .filter(employeePredicate(EmployeeType.WORKER)))
                .collect(Collectors.toSet())
                .size();

        if (employeeType.equals(EmployeeType.SUPERVISOR)) {
            return constructionSites
                    .stream()
                    .flatMap(constructionSite -> constructionSite
                            .getEmployees()
                            .stream()
                            .filter(employeePredicate(employeeType)))
                    .mapToDouble(Employee::getSalary)
                    .sum() + (workers * 0.5);
        }

        return constructionSites
                .stream()
                .flatMap(constructionSite -> constructionSite
                        .getEmployees()
                        .stream()
                        .filter(employeePredicate(employeeType)))
                .mapToDouble(Employee::getSalary)
                .sum();
    }
}
