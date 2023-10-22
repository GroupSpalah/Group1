package homeworks.sergii_khvostov.hw_2023.hw_15_10_23;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConstructionTest {
    public static void main(String[] args) {
        ListEmployees listEmployees = new ListEmployees();
        List<Employee> employees = listEmployees.createEmployees();
        List<ConstructionSite> sites = new ArrayList<>();

        ConstructionSite constructionSite1 = new ConstructionSite(ConstructionType.OFFICE, employees);
        ConstructionSite constructionSite2 = new ConstructionSite(ConstructionType.RESIDENTIAL, employees);
        ConstructionSite constructionSite3 = new ConstructionSite(ConstructionType.APARTMENT, employees);

        sites.add(constructionSite1);
        sites.add(constructionSite2);
        sites.add(constructionSite3);

        ConstructionService cs = new ConstructionService();
        BigDecimal totalSalary = cs.calculateTotalSalary(employees);
        System.out.println("Total salary employees: " + totalSalary);

        long totalOfficeWorkers = (long) cs.averageOfficeWorkers(sites);
        System.out.println("Average number of workers at an office construction site: " +
                totalOfficeWorkers);
    }
}
