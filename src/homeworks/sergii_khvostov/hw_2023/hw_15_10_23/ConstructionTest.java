package homeworks.sergii_khvostov.hw_2023.hw_15_10_23;

import java.math.BigDecimal;

public class ConstructionTest {
    public static void main(String[] args) {
        ConstructionService cs = new ConstructionService();

        ConstructionSite constructionSite1 =
                new ConstructionSite(ConstructionType.OFFICE);
        ConstructionSite constructionSite2 =
                new ConstructionSite(ConstructionType.RESIDENTIAL);
        ConstructionSite constructionSite3 =
                new ConstructionSite(ConstructionType.APARTMENT);

        cs.addSite(constructionSite1);
        cs.addSite(constructionSite2);
        cs.addSite(constructionSite3);

        cs.addEmployees();

        BigDecimal totalSalary = cs.calculateTotalSalary();
        System.out.println("Total salary employees: " + totalSalary);

        double totalOfficeWorkers = cs.findAverageOfficeWorkers();
        System.out.println("Average number of workers at an office construction site: " +
                totalOfficeWorkers);

    }
}
