package lessons.functional_interface;

import java.util.List;
import java.util.function.Function;

public class ReferenceOnConstructor {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", 32),
                new Person("Ben", 38),
                new Person("Jack", 38)
        );

//        Function<Person, Child> function = person -> new Child(person);
        Function<Person, Child> function = Child::new;

        List<Child> children = people
                .stream()
                .map(Child::new)
                .toList();
    }
}

record Person(String name, int age) {

}

record Child(String name, int age) {
    public Child(Person person) {
        this(person.name(), person.age());
    }
}
