package homeworks.vladyslav_lazin.hw_2023.hw_17_12_23;

public class BuggerTask {
    public static void main(String[] args) {
        System.out.println(bugger(333));
    }
    public static int bugger(int number) {
        int multiplication = 1;
        int result = 0;
        if (number > 9) {
            while (number > 9) {
                multiplication *= number % 10;
                number /= 10;
            }
            result = number * multiplication;
        }
        return result < 10 ? result : bugger(result);
    }
}
