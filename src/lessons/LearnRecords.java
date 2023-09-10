package lessons;

import java.io.File;

public class LearnRecords {
    public static void main(String[] args) {
        PersonRecord record = new PersonRecord("John", 23);

//        System.out.println(record.age() + "\t" + record.name());

        System.out.println(record);

        PersonStream ben = new PersonStream("Ben", 30);

        System.out.println(ben);
    }
}

record Student(String name, int age, Group group){}
record Group(int number){}


record PersonRecord(String name, int age){
    public PersonRecord(String name) {
        this(name, 0);
    }
}

class PersonStream {
    private final String name;
    private final int age;

    public PersonStream(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "PersonStream{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/*
* String {
*       print() {
*       sout("Hello");
* }
*
* class ChildString extends String {
*    print() {
 *       sout("World");
 * }
* }
* }
* */

