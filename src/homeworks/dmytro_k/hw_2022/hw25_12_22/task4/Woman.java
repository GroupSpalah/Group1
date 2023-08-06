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
   isRetired (возвращает true, если возраст больше пенсионного порога 60++
   для женщин и 65 для мужчин)
   registerPartnership (подразумевается, что жена принимает фамилию мужа)
   deregisterPartnership (в качестве входного параметра принимает boolean:
   возврат к предыдущей фамилии)
*/

public class Woman extends Person {

    private Person partner;
    private String lastName;

    public Woman(String firstName, String lastName, int age, Person partner) {
        super(firstName, lastName, age);
        this.partner = partner;
        this.lastName = lastName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public boolean isRetired() {

        return getAge() > 60;
    }

    public void registerPartnership() {

        super.setLastName(partner.getLastName());
    }

    public void deregisterPartnership(boolean deregister) {
        if (deregister) {
            super.setLastName(getLastName());
        }
    }
}
