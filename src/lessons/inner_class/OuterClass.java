package lessons.inner_class;

public class OuterClass {
    private int age;
    private static String name;

    class InnerClass {

        public static String firstName = "";

        public void print() {

            System.out.println(age + name);
        }
    }

    static class StaticInner {
        public void stPrint() {
//            System.out.println(age + name);
        }
    }

}

class TestInner {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();

        System.out.println(OuterClass.InnerClass.firstName);

        OuterClass.InnerClass innerClass = outerClass.new InnerClass();

        OuterClass.StaticInner staticInner = new OuterClass.StaticInner();
    }
}
