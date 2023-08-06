package lessons.learn_class;

public class Person {
    private int age;//field age
    private int height;
    private float salary;

    public Person(int newAge, int newHeight, float newSalary) {//incoming params
        if (newAge < 0) {
            age = 1;
        } else {
            age = newAge;
        }
        height = newHeight;
        salary = newSalary;
    }

    //access_modifier void(or return type) name(params or absent) {}

    public void setAge(int newAge) {
        if (newAge < 0) {
            age = 1;
        } else {
            age = newAge;
        }
        age = newAge;
    }

    public int getAge() {
        return age;
    }

    public void print() {
        System.out.println("Age = " + age + "\tHeight = " + height);
    }

}

class TestPerson {
    public static void main(String[] args) {
        //datatype(class_name) name_reference = new datatype(params or absent);

        Person john = new Person(25, 180, 1200);
//        john = new Person(26, 180, 1200);

        john.setAge(-26);

        int johnAge = john.getAge();

        john.print();

//        john.age = -25;
        /*john.height = 180;
        john.salary = 1200;*/

//        Person ben = new Person();

      /*  ben.age = 35;
        ben.height = 170;
        ben.salary = 2200;*/

    }
}
