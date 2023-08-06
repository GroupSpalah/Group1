package homeworks.dmytro_k.hw_2022.hw25_12_22.task4;

/*Опишите классы Man и Woman, наследующие класс Person.

   Оба класса имеют свойства:
   firstName
   lastName
   age
   partner
   другие свойства которые вы считаете необходимыми
   Оба класса имеют методы:
   Конструктор включающий все поля
   сеттер и геттер на поле age, и другие свойства, где это необходимо
   isRetired (возвращает true, если возраст больше пенсионного порога 60 для женщин
   и 65 для мужчин)
   registerPartnership (подразумевается, что жена принимает фамилию мужа)
   deregisterPartnership (в качестве входного параметра принимает boolean:
   возврат к предыдущей фамилии)
*/

public class Person {

    private String firstName ;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void printInfo(){
        System.out.println(firstName + " " + lastName + " " + age);
    }
}
