package homeworks.dmytro_k.hw_2023.hw_08_10_23.task1;

import java.util.List;

/**
 * 2) ++Сущность Man(имя, фамилия, возраст, количество детей, Адрес), Адрес(страна, город, улица, номер дома)
 * Использовать коллекцию LinkedList. Действия для класса Адрес делать из класса Man.
 * - Вывести информацию о всех людях.
 * - Вывести информацию о всех адресах.
 * - Вывести firstName, lastName, countOfChildren, когда возраст более или равно 20 и отсортировать по firstName.
 * - Изменить firstName = 'John', lastName = 'Kennedi', countOfChildren = 3, когда country == 'US' (or another country).
 * - Вывести firstName, lastName, nameOfStreet, когда country == 'Canada' AND numberOfHome == 3 OR age >= 25";
 */

public class Man {
    private String firstName;
    private String lastName;
    private int age;
    private int countOfChildren;
    private final Address ADDRESS;

    public Man(String firstName, String lastName, int age, int countOfChildren, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.countOfChildren = countOfChildren;
        this.ADDRESS = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCountOfChildren() {
        return countOfChildren;
    }

    public void setCountOfChildren(int countOfChildren) {
        this.countOfChildren = countOfChildren;
    }

    public Address getADDRESS() {
        return ADDRESS;
    }

    @Override
    public String toString() {
        return "Man{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", countOfChildren=" + countOfChildren +
                ", address=" + ADDRESS +
                '}';
    }
}
