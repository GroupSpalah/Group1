package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;

public class EventTest {
    public static void main(String[] args) {
        EventService eventService = new EventService();

        CocktailParty cocktailParty = new CocktailParty();

        Wedding wedding = new Wedding();

        Conference conference= new Conference();

        eventService.getEvents().add(conference);
        eventService.getEvents().add(wedding);
        eventService.getEvents().add(cocktailParty);

        eventService.manageEvents();
    }
}





