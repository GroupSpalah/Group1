package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

import java.math.BigDecimal;

public class ConstractionTest {
    public static void main(String[] args) {
        ConstructionSite constructionSite = new ConstructionSite(BuildingType.OFFICE_BUILDING);
        constructionSite.addEmployeeToStaff(new SectionChief("John Doe"));
        constructionSite.addEmployeeToStaff(new FullTimeWorker("Ben Smith"));
        constructionSite.addEmployeeToStaff(new FullTimeWorker("Kenny Long"));
        constructionSite.addEmployeeToStaff(new FullTimeWorker("Kyly Brochlovsky"));
        constructionSite.addEmployeeToStaff(new FullTimeWorker("Eric Cartman"));
        constructionSite.addEmployeeToStaff(new PartTimeWorker("Stanley Walsh"));
        constructionSite.addEmployeeToStaff(new PartTimeWorker("Parry Mayson"));

        ConstructionService constructionService = new ConstructionService();
        System.out.println(constructionService.getWorkersNumber(constructionSite));


    }
}
