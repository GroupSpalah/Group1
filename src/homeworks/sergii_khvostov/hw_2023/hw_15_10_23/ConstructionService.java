package homeworks.sergii_khvostov.hw_2023.hw_15_10_23;

import java.math.BigDecimal;
import java.util.List;

public class ConstructionService {

    public BigDecimal calculateSalary(Employee employee) {
        BigDecimal baseSalary;
        BigDecimal hourlyRate;

        switch (employee.position()) {
            case WORKER -> {
                baseSalary = new BigDecimal(408);
                hourlyRate = new BigDecimal(6);
            }
            case SUPERVISOR -> {
                baseSalary = new BigDecimal(788);
                hourlyRate = new BigDecimal(5);
            }
            case ENGINEER -> {
                baseSalary = new BigDecimal(700);
                hourlyRate = new BigDecimal(40);
            }
            default -> {
                baseSalary = BigDecimal.ZERO;
                hourlyRate = BigDecimal.ZERO;
            }
        }

        return baseSalary.add(hourlyRate.multiply(new BigDecimal(employee.hoursWorked())));
    }

    public BigDecimal calculateTotalSalary(List<Employee> employees) {
        return employees.stream()
                .map(this::calculateSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public double averageOfficeWorkers(List<ConstructionSite> sites) {

        boolean hasEngineer = sites.stream()
                .anyMatch(ConstructionSite::hasEngineer);

        if (!hasEngineer) {
            System.out.println("There is no engineer on site");
            return 0.0;
        }

        List<ConstructionSite> officeSites = sites.stream()
                .filter(site -> site.type() == ConstructionType.OFFICE)
                .toList();

        long totalOfficeWorkers = officeSites.stream()
                .mapToLong(site -> site.employees().size())
                .sum();

        return totalOfficeWorkers * 1.0 / officeSites.size();
    }
}
