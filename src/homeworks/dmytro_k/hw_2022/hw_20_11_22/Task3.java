package homeworks.dmytro_k.hw_2022.hw_20_11_22;

public class Task3 {

    public static void main(String[] args) {

        resolve(1, 1);

        sum(-1000,999);
    }

    public static void sum(int a, int b) {

        int sum = a + b;

        if (a < -1000 || b > 1000) {
            System.out.println("value outside the condition");
            return;
        }

        System.out.println(sum);
    }

    public static void resolve(int n, int k) {

        int result = n * 3 + k * 4;

        if (n < 0 || k > 10000) {
            System.out.println("value outside the condition");
            return;
        }

        System.out.println(result);
    }
}
