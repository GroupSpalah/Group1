package homeworks.sergii_khvostov.hw_2023.hw_03_03_23.task1;

/*Create class Person with fields firstName(of String type),
 lastName(String), age(int).
 Create InvalidAgeException class that is subclass of Exception.
 App should throw InvalidAgeException when age out of range 1-120 in constructor.*/

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age)
            throws InvalidAgeException {

        if (age < 1 || age > 120) {
            throw new InvalidAgeException("Invalid age: " + age);
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
