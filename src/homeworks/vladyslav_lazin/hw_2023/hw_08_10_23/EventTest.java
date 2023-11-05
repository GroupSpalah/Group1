package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;

import java.util.Set;

public class EventTest {
    public static void main(String[] args) {
        EventOrganizerCompanyService eventOrganizerCompanyService = new EventOrganizerCompanyService();
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("John Doe", Role.ORGANIZER,7));
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("Ben Smith", Role.ORGANIZER, 3));
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("Kenny Brown", Role.ORGANIZER, 12));
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("Helen Hell", Role.ORGANIZER, 0));
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("Elisa Day", Role.ASSISTENT));
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("Sarah Crow", Role.ASSISTENT));
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("Sasha Grey", Role.ASSISTENT));
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("Paula Abdul", Role.ASSISTENT));
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("Kathy Jones", Role.ASSISTENT));
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("Kitty Fox", Role.ASSISTENT));
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("Ron Jeremy", Role.ASSISTENT));
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("Ray Charles", Role.ASSISTENT));
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("Tony Catch", Role.ASSISTENT));
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("John Walker", Role.ASSISTENT));
        eventOrganizerCompanyService.addEmployeeToStaff(new Employee("Joe Folkner", Role.ASSISTENT));

        Event event = new CocktailParty(Set.of(Cocktail.BLOODY_MARY, Cocktail.GINN_TONIC, Cocktail.RUM_COLA, Cocktail.SLEZA_KOMSONOLKI));
        eventOrganizerCompanyService.organizeEvent(event);
        System.out.println(event);
        System.out.println(eventOrganizerCompanyService.getStaff());
        System.out.println(eventOrganizerCompanyService.getTheBestOrganizer());
        System.out.println(event.getMainOrganizer());
        System.out.println("__________________________________________");
        eventOrganizerCompanyService.getStaff().forEach(System.out::println);
    }
}
