package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;

import homeworks.dmytro_k.hw_2023.hw_12_01_23.task2_2.A;

import java.util.List;

public class EventTest {
    public static void main(String[] args) {
        Event event = new CocktailParty(
                List.of(new Organizer("John Doe", 7),
                        new Assistant("Ben Smith"),
                        new Organizer("Kenny Brown", 12),
                        new Organizer("Elisa Day", 9),
                        new Assistant("Sarah Crow"),
                        new Assistant("Sasha Grey"),
                        new Assistant("Kathy Jones"),
                        new Assistant("Kitty Fox"),
                        new Assistant("Ron Jeremy")
                        ), 145);
//        EventOrganizerCompany.getCompanyStaff();
    }
}
