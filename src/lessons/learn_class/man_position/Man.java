package lessons.learn_class.man_position;

/**
 * Создать класс Man c полями имя, пол(использовать Enum) фамилия, возраст, должность.
 * Для должности создать отдельный класс с полем название должности.
 *
 * Создать несколько людей с одинаковой и разными должностями.
 * Создать методы позволяющие:
 *  - вывести данные о человеке.
 *  - проверять должности на одинаковость у двух людей.
 *  - проверять однофамильцев у двух людей.
 *
 */
public class Man {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private Position position;

    public Man(String firstName, String lastName, int age, Gender gender, Position position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.position = position;
    }

    public String getLastName() {
        return lastName;
    }

    public Position getPosition() {
        return position;
    }
}
