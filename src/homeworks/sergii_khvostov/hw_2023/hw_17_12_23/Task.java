package homeworks.sergii_khvostov.hw_2023.hw_17_12_23;

/*Дано 4-х значне число (1985) знайти в числі найбільше непарне число вивести
 його на консоль і порахувати кількість одиниць в числі.*/

public class Task {
    public static void main(String[] args) {
        int num = 1985;
        System.out.println(countOnes(num));
        System.out.println(findMaxOdd(num));

    }

    public static int findMaxOdd(int num) {
        if (num == 0) {
            return -1;
        }

        int digit = num % 10;
        if (digit % 2 != 0) {
            int maxFromRest = findMaxOdd(num / 10);
            return Math.max(maxFromRest, digit);
        } else {
            return findMaxOdd(num / 10);
        }
    }

    public static int countOnes(int num) {
        if (num == 0) {
            return 0;
        }

        int digit = num % 10;
        if (digit == 1) {
            return 1 + countOnes(num / 10);
        } else {
            return countOnes(num / 10);
        }
    }
}
