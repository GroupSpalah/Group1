package lessons.learn_class;

public class LearnConstants {
    public static void main(String[] args) {
        final int a = 10;

//        a = 15;
        print(5);

//        System.out.println(ForConstants.COUNT);
    }

    public static void print(final int count) {
//        count = 10;
    }
}

class ForConstants {
    private final int age;//non-static constant
    public final static int COUNT = 10;

    {
        System.out.println("Non-static block initialization");
        age = 10;
    }

    static {
        System.out.println("Static block initialization");
//        COUNT = 10;
    }

    private float salary;

    public ForConstants(int age) {
        System.out.println("Constructor");
//        this.age = age;
    }

    public ForConstants(int age, float salary) {
        System.out.println("Constructor");
//        this.age = age;
        this.salary = salary;
    }
}
