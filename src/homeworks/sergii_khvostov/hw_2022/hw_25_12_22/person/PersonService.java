package homeworks.sergii_khvostov.hw_2022.hw_25_12_22.person;

public class PersonService extends Person {
    public PersonService(String firstName, String lastName, int age,
                         String gender, int phoneNumber) {
        super(firstName, lastName, age, gender, phoneNumber);
    }

    public static void main(String[] args) {
        Person person = new Person();

        person.printInfo("Nik");
        person.printInfo("Nik", "Koul");
        person.printInfo("Nik", "Koul", 35);
        person.printInfo("Nik", "Koul", 35, "male");
        person.printInfo("Nik", "Koul", 35,
                "male", 625166161);

    }
}
