package homeworks.dmytro_m.hw_2023.hw_03_03_2023.task1;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) throws InvalidAgeException {
        if(age < 1 || age > 120) {
            throw new InvalidAgeException("You entered the age");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
//1) Создайте класс Person с полями firstName (типа String), lastName (String), age (int).
//        Создайте класс InvalidAgeException, который является подклассом Exception.
//        Приложение должно генерировать InvalidAgeException, когда возраст выходит за пределы диапазона 1-120 в конструкторе.