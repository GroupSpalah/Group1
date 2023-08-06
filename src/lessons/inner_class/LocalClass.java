package lessons.inner_class;

public class LocalClass {
    public void print(int age) {

//        age = 10;
        class LClass {
            public static int count = 0;

            public void action() {
                System.out.println(age);
            }
        }

//        age = 10;

        System.out.println(LClass.count);
    }

    public static void main(String[] args) {
        for (; ;) {
            class Foo {

            }
        }
    }
}
