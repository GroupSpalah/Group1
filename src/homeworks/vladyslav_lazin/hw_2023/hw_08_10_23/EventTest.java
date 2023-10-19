package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;

import java.util.List;
import java.util.Set;

public class EventTest {
    public static void main(String[] args) {
        EventOrganizerCompanySrvice eventOrganizerCompanySrvice = new EventOrganizerCompanySrvice();
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("John Doe", Role.ORGANIZER,7));
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("Ben Smith", Role.ORGANIZER, 3));
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("Kenny Brown", Role.ORGANIZER, 12));
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("Helen Hell", Role.ORGANIZER, 0));
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("Elisa Day", Role.ASSISTENT));
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("Sarah Crow", Role.ASSISTENT));
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("Sasha Grey", Role.ASSISTENT));
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("Paula Abdul", Role.ASSISTENT));
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("Kathy Jones", Role.ASSISTENT));
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("Kitty Fox", Role.ASSISTENT));
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("Ron Jeremy", Role.ASSISTENT));
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("Ray Charles", Role.ASSISTENT));
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("Tony Catch", Role.ASSISTENT));
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("John Walker", Role.ASSISTENT));
        eventOrganizerCompanySrvice.addEmployeeToStaff(new Employee("Joe Folkner", Role.ASSISTENT));

        Event event = new CocktailParty(Set.of("Bloody Mary", "Sex at the Beach", "Yorsh", "Rum-cola"));
        eventOrganizerCompanySrvice.createEvent(event);
        System.out.println(eventOrganizerCompanySrvice.getTheBestOrganizer());

        System.out.println(event);
    }
}
