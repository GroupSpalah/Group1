package homeworks.dmytro_k.hw_2023.hw_17_12_23;

/**
 * 1) Дано 4-х значне число (1985) знайти в числі найбільше непарне число вивести
 * його на консоль і порахувати кількість одиниць в числі.
 */

public class Task1 {

    public static void main(String[] args) {
        int value = 1988;
        int count = 0;
        int result = maxOddNumber(value);
        int units = unitsCount(result, count);
        System.out.println(result);
        System.out.println(units);
    }

    public static int unitsCount(int value, int count) {
        if (value % 10 == 1) {
            count++;
        }
        if (value < 10) {
            return count;
        }
        return unitsCount(value / 10, count);
    }

    public static int maxOddNumber(int value) {

        if (value % 2 != 0) {
            return value;
        }

        if (value < 10) {
            return 0;
        }

        return maxOddNumber(value / 10);
    }

    public static int maxOddNumberV2(int value) {

        if (value % 2 != 0) {
            return value;
        }

        if (value < 10) {
            return value - 1;
        }

        return maxOddNumberV2(value - 1);
    }
}
