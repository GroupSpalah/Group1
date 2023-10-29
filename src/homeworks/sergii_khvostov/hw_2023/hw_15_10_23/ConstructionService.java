package homeworks.sergii_khvostov.hw_2023.hw_15_10_23;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConstructionService {

    private List<ConstructionSite> sites;
    private List<Employee> employees;

    public ConstructionService() {
        sites = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public BigDecimal calculateSalary(Employee employee) {
        BigDecimal baseSalary = employee.getPosition().getBaseSalary();
        BigDecimal hourlyRate = employee.getPosition().getHourlyRate();

        return baseSalary.add(hourlyRate.multiply(new BigDecimal(employee.getHoursWorked())));
    }

    public BigDecimal calculateTotalSalary() {
        return employees.stream()
                .map(this::calculateSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public double averageOfficeWorkers() {

        boolean hasEngineer = sites.stream()
                .anyMatch(ConstructionSite::hasEngineer);

        if (!hasEngineer) {
            System.out.println("There is no engineer on site");
            return 0.0;
        }

        List<ConstructionSite> officeSites = sites.stream()
                .filter(site -> site.type() == ConstructionType.OFFICE)
                .toList();

        double totalOfficeWorkers = officeSites.stream()
                .mapToInt(site -> site.employees().size())
                .sum();

        return totalOfficeWorkers / officeSites.size();
    }

    public void fillEmployees() {
        List<Employee> employeesList = ListEmployees.createEmployees();
        employees.addAll(employeesList);
    }

    public void addSite(ConstructionSite site) {
        sites.add(site);
    }
}
