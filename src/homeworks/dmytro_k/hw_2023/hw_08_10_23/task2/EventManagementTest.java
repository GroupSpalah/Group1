package homeworks.dmytro_k.hw_2023.hw_08_10_23.task2;

public class EventManagementTest {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Ben", EmployeeType.ASSISTANTS);
        Employee employee2 = new Employee("Den", EmployeeType.ASSISTANTS);
        Employee employee3 = new Employee("Ken", EmployeeType.ASSISTANTS);
        Employee employee4 = new Employee("Ron", EmployeeType.ASSISTANTS);
        Employee employee5 = new Employee("Jon", EmployeeType.ASSISTANTS);
        Employee employee6 = new Employee("Shon", EmployeeType.ASSISTANTS);
        Employee employee7 = new Employee("Anna", EmployeeType.ASSISTANTS);
        Employee employee8 = new Employee("Lily", EmployeeType.ASSISTANTS);
        Employee employee9 = new Employee("Amanda", EmployeeType.ASSISTANTS);
        Employee employee10 = new Employee("Jake", EmployeeType.ASSISTANTS);
        Employee employee11 = new Employee("Dik", EmployeeType.ASSISTANTS);
        Employee employee12 = new Employee("Jack", EmployeeType.ASSISTANTS);
        Employee employee13 = new Employee("Jack", EmployeeType.ASSISTANTS);
        Employee employee14 = new Employee("Bob", EmployeeType.ORGANIZER);
        Employee employee15 = new Employee("Tom", EmployeeType.ORGANIZER);
        Employee employee16 = new Employee("Robert", EmployeeType.ORGANIZER);
        Employee employee17 = new Employee("Emily", EmployeeType.MAIN_ORGANIZER);
        Employee employee18 = new Employee("Colin", EmployeeType.MAIN_ORGANIZER);
        Employee employee19 = new Employee("Victor", EmployeeType.MAIN_ORGANIZER);

        Wedding wedding1 = new Wedding(true);
        Wedding wedding2 = new Wedding(false);
        Wedding wedding3 = new Wedding(true);

        Conferences conferences1 = new Conferences();

        CocktailParty cocktailParties1 = new CocktailParty();
        CocktailParty cocktailParties2 = new CocktailParty();

        wedding1.addEmployee(employee1);
        wedding1.addEmployee(employee2);
        wedding1.addEmployee(employee3);
        wedding1.addEmployee(employee4);
        wedding1.addEmployee(employee5);
        wedding1.addEmployee(employee6);
        wedding1.addEmployee(employee7);
        wedding1.addEmployee(employee8);
        wedding1.addEmployee(employee9);
        wedding1.addEmployee(employee10);
        wedding1.addEmployee(employee14);
        wedding1.addEmployee(employee15);
        wedding1.addEmployee(employee17);
        wedding1.addEmployee(employee18);//second, test

        wedding3.addEmployee(employee1);
        wedding3.addEmployee(employee2);
        wedding3.addEmployee(employee3);
        wedding3.addEmployee(employee4);
        wedding3.addEmployee(employee5);
        wedding3.addEmployee(employee6);
        wedding3.addEmployee(employee7);
        wedding3.addEmployee(employee8);
        wedding3.addEmployee(employee9);
        wedding3.addEmployee(employee10);
        wedding3.addEmployee(employee14);
        wedding3.addEmployee(employee16);
        wedding3.addEmployee(employee17);

        cocktailParties1.addEmployee(employee1);
        cocktailParties1.addEmployee(employee2);
        cocktailParties1.addEmployee(employee3);
        cocktailParties1.addEmployee(employee4);
        cocktailParties1.addEmployee(employee5);
        cocktailParties1.addEmployee(employee6);
        cocktailParties1.addEmployee(employee7);
        cocktailParties1.addEmployee(employee8);
        cocktailParties1.addEmployee(employee11);
        cocktailParties1.addEmployee(employee12);
        cocktailParties1.addEmployee(employee14);
        cocktailParties1.addEmployee(employee16);
        cocktailParties1.addEmployee(employee18);

        cocktailParties2.addEmployee(employee1);
        cocktailParties2.addEmployee(employee2);
        cocktailParties2.addEmployee(employee3);
        cocktailParties2.addEmployee(employee4);
        cocktailParties2.addEmployee(employee5);
        cocktailParties2.addEmployee(employee6);
        cocktailParties2.addEmployee(employee7);
        cocktailParties2.addEmployee(employee8);
        cocktailParties2.addEmployee(employee11);
        cocktailParties2.addEmployee(employee12);
        cocktailParties2.addEmployee(employee14);
        cocktailParties2.addEmployee(employee16);
        cocktailParties2.addEmployee(employee19);

        conferences1.addEmployee(employee13);

        EventManagement eventManagement = new EventManagement();

        eventManagement.add(wedding1);
        eventManagement.add(wedding2);
        eventManagement.add(wedding3);
        eventManagement.add(conferences1);
        eventManagement.add(cocktailParties1);
        eventManagement.add(cocktailParties2);

        eventManagement.topOrganizer();
    }
}
