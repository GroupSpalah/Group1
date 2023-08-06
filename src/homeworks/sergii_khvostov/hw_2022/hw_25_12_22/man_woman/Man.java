package homeworks.sergii_khvostov.hw_2022.hw_25_12_22.man_woman;

/*Опишите классы Man и Woman, наследующие класс Person.
  Оба класса имеют свойства:
firstName
lastName
age
partner
другие свойства которые вы считаете необходимыми
Оба класса имеют методы:
Конструктор включающий все поля
сеттер и геттер на поле age, и другие свойства, где это необходимо.
isRetired (возвращает true, если возраст больше пенсионного порога 60
для женщин и 65 для мужчин)
registerPartnership (подразумевается, что жена принимает фамилию мужа)
deregisterPartnership (в качестве входного параметра принимает boolean:
возврат к предыдущей фамилии)*/

import homeworks.sergii_khvostov.hw_2022.hw_25_12_22.person.Person;

public class Man extends Person {

    private String firstName;
    private String lastName;
    private int age;
    private boolean married;
    private String partner;
    private Woman woman;

    public Man(String firstName, String lastName, int age, String gender,
               int phoneNumber, boolean married, String partner) {
        super(firstName, lastName, age, gender, phoneNumber);
        this.married = married;
        this.partner = partner;
        this.age = age;
    }


    @Override
    public int getAge() {
        return age;
    }


    public boolean isMarried() {
        return married;
    }

    public String getPartner() {
        return partner;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }


    public Woman getWoman() {
        return woman;
    }

    public boolean isRetired(int age) {
        return age > 65 ? true : false;
    }

    public void registerPartnership(Woman woman) {
        setPartner(woman.getFirstName() + woman.getLastName());
        setMarried(true);
    }

    public void deregisterPartnership(boolean married) {
        if (!married) {
            setPartner("No");
        }
    }

    public void printInfo() {
        System.out.println("Name: " + getFirstName() + "\n" + "Surname: " +
                getLastName() + "\n" + "Age: " + getAge() + "\n" +
                "Gender: " + getGender() + "\n" + "Phone: " +
                getPhoneNumber() + "\n" + "Married: " + isMarried() +
                "\n" + "Partner: " + getPartner());
    }
}
