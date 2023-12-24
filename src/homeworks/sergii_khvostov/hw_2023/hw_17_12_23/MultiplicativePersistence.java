package homeworks.sergii_khvostov.hw_2023.hw_17_12_23;

/*Create a function that takes a number and returns its multiplicative persistence, which is the
 * number of times you must multiply the digits in num until you reach a single digit.
 * Example:
 * number(39) -> 3
 * //Because 3 * 9 = 27, 2 * 7 = 14, 1 * 4 = 4 and 4 has only one digit.
 * number(999) -> 4
 * //Because 9 * 9 = 729, 7 * 2 * 9 = 126, 1 * 2 * 6 = 12, and finally 1 * 2 = 2,
 * number(4) -> 0
 * //Because 4 is already a one-digit number.*/

public class MultiplicativePersistence {
    public static void main(String[] args) {
        int num = 939;
        System.out.println(multPers(num));
    }

    public static int multPers(int num) {
        if (num < 10) {
            return 0;
        } else {
            int value = 1;
            while (num != 0) {
                value *= num % 10;
                num /= 10;
            }
            int result = multPers(value);
            return 1 + result;
        }
    }
}
