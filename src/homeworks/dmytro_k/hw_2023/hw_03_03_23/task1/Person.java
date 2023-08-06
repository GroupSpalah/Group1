package homeworks.dmytro_k.hw_2023.hw_03_03_23.task1;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        if (1 > age || age > 120) {
            try {
                throw new InvalidAgeException("Incorrect value: " + age);
            } catch (InvalidAgeException e) {
                e.printStackTrace();
            }
        }
    }
}

