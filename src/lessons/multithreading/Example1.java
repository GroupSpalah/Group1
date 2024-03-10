package lessons.multithreading;

public class Example1 {
    public static void main(String[] args) {
        System.out.println("Hello");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("Good Buy");
    }
}
// задача: просуммировать все числа от 1 до 1000
// 1..250
// 251..500
// 501..750
// 751..1000