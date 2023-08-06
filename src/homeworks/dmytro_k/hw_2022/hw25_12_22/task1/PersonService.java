package homeworks.dmytro_k.hw_2022.hw25_12_22.task1;

public class PersonService {

    public static void main(String[] args) {

        Person person1 = new Person("Jack","Nicholson","male",85,1234567890);

        person1.printInfo(person1.getFirstName());
        person1.printInfo(person1.getFirstName(), person1.getLastName());
        person1.printInfo(person1.getFirstName(), person1.getLastName(), person1.getGender());
        person1.printInfo(person1.getFirstName(), person1.getLastName(), person1.getGender(), person1.getAge());
        person1.printInfo(person1.getFirstName(), person1.getLastName(), person1.getGender(), person1.getAge(), person1.getPhoneNumber());
    }
}
