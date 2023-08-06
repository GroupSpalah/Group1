package homeworks.sergii_khvostov.hw_2022.hw_18_12_22.airboard;

public class AirboardTest {
    public static void main(String[] args) {
        Airboard airboard =
                new Airboard("Airbus", "A380",
                        800, 8000);
        System.out.println(airboard.info());
        System.out.println();

        Bomber bomber =
                new Bomber("Affet", "WC135",
                        1000, 12000);
        System.out.println(bomber.info());
        System.out.println();

        Fighter fighter =
                new Fighter("Lockheed Martin", "F35",
                        1500, 14000);
        System.out.println(fighter.info());
    }
}
