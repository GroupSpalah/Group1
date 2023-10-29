package homeworks.sergii_khvostov.hw_2023.hw_15_10_23;

import java.math.BigDecimal;

public class ConstructionTest {
    public static void main(String[] args) {

        ConstructionSite constructionSite1 =
                new ConstructionSite(ConstructionType.OFFICE, ListEmployees.createEmployees());
        ConstructionSite constructionSite2 =
                new ConstructionSite(ConstructionType.RESIDENTIAL, ListEmployees.createEmployees());
        ConstructionSite constructionSite3 =
                new ConstructionSite(ConstructionType.APARTMENT, ListEmployees.createEmployees());


        ConstructionService cs = new ConstructionService();
        cs.addSite(constructionSite1);
        cs.addSite(constructionSite2);
        cs.addSite(constructionSite3);
        cs.fillEmployees();
        BigDecimal totalSalary = cs.calculateTotalSalary();
        System.out.println("Total salary employees: " + totalSalary);

        double totalOfficeWorkers = cs.averageOfficeWorkers();
        System.out.println("Average number of workers at an office construction site: " +
                totalOfficeWorkers);

    }
}
