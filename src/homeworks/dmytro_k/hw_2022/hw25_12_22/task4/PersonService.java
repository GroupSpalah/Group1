package homeworks.dmytro_k.hw_2022.hw25_12_22.task4;

public class PersonService {

    public static void main(String[] args) {

        Man man1 = new Man("FN1", "LN1", 30);
        Woman woman2 = new Woman("FN2", "LN2", 28, man1);

        woman2.printInfo();

        woman2.registerPartnership();
        woman2.printInfo();

        woman2.deregisterPartnership(true);
        woman2.printInfo();

        System.out.println(man1.isRetired());
    }
}
