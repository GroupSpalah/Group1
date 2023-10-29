package homeworks.sergii_khvostov.hw_2023.hw_15_10_23;

import java.math.BigDecimal;

import static homeworks.sergii_khvostov.hw_2023.hw_15_10_23.ConstructionService.sites;

public class ConstructionTest {
    public static void main(String[] args) {

        ConstructionSite constructionSite1 =
                new ConstructionSite(ConstructionType.OFFICE, ListEmployees.createEmployees());
        ConstructionSite constructionSite2 =
                new ConstructionSite(ConstructionType.RESIDENTIAL, ListEmployees.createEmployees());
        ConstructionSite constructionSite3 =
                new ConstructionSite(ConstructionType.APARTMENT, ListEmployees.createEmployees());

        sites.add(constructionSite1);
        sites.add(constructionSite2);
        sites.add(constructionSite3);

        ConstructionService cs = new ConstructionService();
        cs.fillEmployees();
        BigDecimal totalSalary = cs.calculateTotalSalary();
        System.out.println("Total salary employees: " + totalSalary);

        double totalOfficeWorkers = cs.averageOfficeWorkers();
        System.out.println("Average number of workers at an office construction site: " +
                totalOfficeWorkers);

    }
}
