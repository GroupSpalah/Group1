package homeworks.sergii_khvostov.hw_2022.hw_25_12_22.man_woman;

public class ManWomanService {
    public static void main(String[] args) {

        Man man1 =
                new Man("Alex", "Kole", 35,
                        "male", 1532825,
                        true, "Jenny Hoop");
        man1.printInfo();
        System.out.println();

        Woman woman1 =
                new Woman("Jenny", "Hoop", 33,
                        "female", 6161651,
                        true,
                        man1.getFirstName() + man1.getLastName());


        woman1.registerPartnership(man1);
        woman1.printInfo();


    }

}
