package homeworks.vladyslav_lazin.hw_2023.hw_17_12_23;

public class BuggerTask {
    public static int count = 0;

    public static void main(String[] args) {
        System.out.println(bugger(4));
    }

    //    public static int bugger(int number) {
//        int multiplication = 1;
//        int result = 0;
//        if (number > 9) {
//            while (number > 9) {
//                multiplication *= number % 10;
//                number /= 10;
//            }
//            result = number * multiplication;
//        }
//        return result < 10 ? result : bugger(result);
//    }
    public static int bugger(int number) {
        int multiplication = 1;
        int result = 0;
        if (number > 9) {
            count++;
            while (number > 9) {
                multiplication *= number % 10;
                number /= 10;
            }
            result = number * multiplication;
        }
        if (result > 9) {
            bugger(result);
        }
        return count;
    }
}
