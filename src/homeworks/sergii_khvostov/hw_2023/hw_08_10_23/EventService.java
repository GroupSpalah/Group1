package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;

public class EventService {
    public static void main(String[] args) {
        ListEmployeesAndEvents employeesAndEvents = new ListEmployeesAndEvents();
        EventManagement eventManagement = new EventManagement(employeesAndEvents.addEvent());
        eventManagement.manageEvents();
    }
}



