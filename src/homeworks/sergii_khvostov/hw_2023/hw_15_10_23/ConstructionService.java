package homeworks.sergii_khvostov.hw_2023.hw_15_10_23;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConstructionService {

    private List<ConstructionSite> sites;

    public ConstructionService() {
        sites = new ArrayList<>();
    }

    public BigDecimal calculateSalary() {
        return sites.stream()
                .flatMap(site -> site.getEmployees().stream())
                .map(employee -> {
                    BigDecimal baseSalary = employee.getPosition().getBaseSalary();
                    BigDecimal hourlyRate = employee.getPosition().getHourlyRate();
                    if (employee.isFullDay()) {
                        return baseSalary;
                    } else {
                        return hourlyRate.multiply(new BigDecimal(employee.getHoursWorked()));
                    }
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateTotalSalary() {
        return sites.stream()
                .flatMap(site -> site.getEmployees().stream())
                .map(employee -> calculateSalary())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public double findAverageOfficeWorkers() {

        boolean hasEngineer = sites.stream()
                .anyMatch(ConstructionSite::hasEngineer);

        if (!hasEngineer) {
            System.out.println("There is no engineer on site");
            return 0.0;
        }

        List<ConstructionSite> officeSites = sites.stream()
                .filter(site -> site.getType() == ConstructionType.OFFICE)
                .toList();

        double totalOfficeWorkers = officeSites.stream()
                .mapToDouble(site -> site.getEmployees().size())
                .sum();

        return totalOfficeWorkers / officeSites.size();
    }

    public void addEmployees() {
        List<Employee> employeesList = ListEmployees.createEmployees();
        sites.forEach(site -> site.getEmployees().addAll(employeesList));
    }

    public void addSite(ConstructionSite site) {
        sites.add(site);
    }
}
