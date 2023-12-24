package homeworks.dmytro_k.hw_2023.hw_17_12_23;

public class Task2 {
    public static void main(String[] args) {
        int value = 999;
        int count = 0;
        int result = calculateIterations(value, count);
        System.out.println("Iteration count: " + result);
    }


    public static int calculateIterations(int value, int count) {
        if (value < 10) {
            return count;
        }
        return calculateIterations(product(value), ++count);
    }

    public static int product(int value) {
        if (value < 10) {
            return value;
        }
        return (value % 10) * product(value / 10);
    }

}

