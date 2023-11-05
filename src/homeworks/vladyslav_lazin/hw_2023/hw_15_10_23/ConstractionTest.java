package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

import java.math.BigDecimal;

public class ConstractionTest {
    public static void main(String[] args) {
        ConstructionSite constructionSite = new ConstructionSite(BuildingType.OFFICE_BUILDING);
        constructionSite.addEmployeeToStaff(new Employee("Cahrles Manson", Position.SUPERVISOR, false, 168));
        constructionSite.addEmployeeToStaff(new Employee("John Doe", Position.SECTION_CHIEF, false, 176));
        constructionSite.addEmployeeToStaff(new Employee("Ben Smith", Position.WORKER, false, 176));
        constructionSite.addEmployeeToStaff(new Employee("Kenny Long", Position.WORKER, false, 152));
        constructionSite.addEmployeeToStaff(new Employee("Kyle Brochlovsky", Position.WORKER, false, 144));
        constructionSite.addEmployeeToStaff(new Employee("Eric Cartman", Position.WORKER, false, 176));
        constructionSite.addEmployeeToStaff(new Employee("Stanley Walsh", Position.WORKER, true, 96));
        constructionSite.addEmployeeToStaff(new Employee("Parry Mayson", Position.WORKER, true, 112));
        constructionSite.addEmployeeToStaff(new Employee("Rex Stout", Position.SECTION_CHIEF, true, 40));


        ConstructionService constructionService = new ConstructionService();
        System.out.println(constructionService.getWorkersNumber(constructionSite));

        System.out.println(constructionService.calculateStaffSalary(constructionSite));
    }
}
