package homeworks.dmytro_k.hw_2023.hw_15_10_23;

/*
 * Следующий модуль приложения — управление ходом строительных площадок. Существуют различные
 * типы строительных площадок(по количеству часов постройки):
 * ++ жилые дома(10000), многоквартирные дома(1000000) и офисные здания(2000000).
 * ++ На каждой строительной площадке есть список ответственных за нее сотрудников.
 * ++ Прогресс на стройке начинается только в том случае, если один из сотрудников является инженером.
 * Наконец, для отчетности компания хочет знать,
 * каково среднее количество рабочих на строительной площадке офисного здания.
 * Посчитать общую сумму зарплат всем рабочим. Присутствует инженер
 */

import java.util.ArrayList;
import java.util.List;

public class ConstructionSite {

    private final List<Employee> employees;
    private final ConstructionSiteType constructionSiteType;
    private boolean progress;

    public ConstructionSite(ConstructionSiteType constructionSiteType) {
        this.employees = new ArrayList<>();
        this.constructionSiteType = constructionSiteType;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public ConstructionSiteType getConstructionSiteType() {
        return constructionSiteType;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        if (employee.getEmployeeType().equals(EmployeeType.ENGINEER)) {
            progress = true;
        }
    }

    @Override
    public String toString() {
        return "ConstructionSite{" +
                "employees = " + employees +
                ", constructionSiteType = " + getConstructionSiteType().name() +
                ", " + constructionSiteType +
                ", progress = " + progress +
                '}' + "\n";
    }
}
