package homeworks.sergii_khvostov.hw_2022.hw_25_12_22.person;

/*Create class Person with fields firstName(String), lastName(String),
age(int), gender(String), phoneNumber(int),and five overloaded methods.
Create class that will be use instance of class Person and his methods.*/

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private int phoneNumber;

    public Person(String firstName, String lastName, int age,
                  String gender, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void printInfo(String firstName) {
        System.out.println(firstName);
    }

    public void printInfo(String firstName, String lastName) {
        System.out.println(firstName + " " + lastName);
    }

    public void printInfo(String firstName, String lastName, int age) {
        System.out.println(firstName + " " + lastName + " " + age);
    }

    public void printInfo(String firstName, String lastName,
                          int age, String gender) {
        System.out.println(firstName + " " + lastName + " " + age +
                " " + gender);
    }

    public void printInfo(String firstName, String lastName, int age,
                          String gender, int phoneNumber) {
        System.out.println(firstName + " " + lastName + " " + age +
                " " + gender + " " + phoneNumber);
    }
}
