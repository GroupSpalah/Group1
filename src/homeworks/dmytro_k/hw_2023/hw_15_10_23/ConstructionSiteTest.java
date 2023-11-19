package homeworks.dmytro_k.hw_2023.hw_15_10_23;

public class ConstructionSiteTest {
    public static void main(String[] args) {

        ConstructionSiteService constructionSiteService = new ConstructionSiteService();

        Employee employee1 = new Employee("A", EmployeeType.ENGINEER, 156, true);
        Employee employee2 = new Employee("B", EmployeeType.WORKER, 100,false);
        Employee employee3 = new Employee("C", EmployeeType.SUPERVISOR, 156, true);
        Employee employee4 = new Employee("D", EmployeeType.WORKER, 100,false);
        Employee employee5 = new Employee("E", EmployeeType.ENGINEER, 156, true);
        Employee employee6 = new Employee("F", EmployeeType.WORKER, 100,false);
        Employee employee7 = new Employee("G", EmployeeType.WORKER, 156,true);
        Employee employee8 = new Employee("H", EmployeeType.WORKER, 100,false);
        Employee employee9 = new Employee("I", EmployeeType.ENGINEER, 156,true);
        Employee employee10 = new Employee("J", EmployeeType.SUPERVISOR, 100,false);
        Employee employee11 = new Employee("K", EmployeeType.WORKER, 156,true);
        Employee employee12 = new Employee("L", EmployeeType.WORKER, 100,false);

        ConstructionSite constructionSite1 = new ConstructionSite(ConstructionSiteType.APARTMENT_BUILDING);
        ConstructionSite constructionSite2 = new ConstructionSite(ConstructionSiteType.RESIDENTIAL_BUILDING);
        ConstructionSite constructionSite3 = new ConstructionSite(ConstructionSiteType.OFFICE_BUILDING);
        ConstructionSite constructionSite4 = new ConstructionSite(ConstructionSiteType.OFFICE_BUILDING);

        constructionSite1.addEmployee(employee1);
        constructionSite1.addEmployee(employee2);
        constructionSite1.addEmployee(employee3);
        constructionSite1.addEmployee(employee4);
        constructionSite2.addEmployee(employee5);
        constructionSite2.addEmployee(employee6);
        constructionSite2.addEmployee(employee7);
        constructionSite2.addEmployee(employee8);
        constructionSite3.addEmployee(employee9);
        constructionSite3.addEmployee(employee10);
        constructionSite3.addEmployee(employee11);
        constructionSite3.addEmployee(employee12);
        constructionSite4.addEmployee(employee5);
        constructionSite4.addEmployee(employee6);
        constructionSite4.addEmployee(employee7);
        constructionSite4.addEmployee(employee8);

        constructionSiteService.addConstructionSite(constructionSite1);
        constructionSiteService.addConstructionSite(constructionSite2);
        constructionSiteService.addConstructionSite(constructionSite3);
        constructionSiteService.addConstructionSite(constructionSite4);

        constructionSiteService.getAverageNumberOfficeBuildingEmployees2();

        System.out.println(constructionSite1);

        System.out.println(constructionSiteService.sumSalaries(EmployeeType.WORKER));
        System.out.println(constructionSiteService.sumSalaries(EmployeeType.SUPERVISOR));
    }
}
