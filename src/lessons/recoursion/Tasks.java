package lessons.recoursion;

/**
 * Дано 4-х значне число (1985) знайти в числі всі парні цифри вивести їх на консоль і
 * порахувати їхню кількість.
 * <p>
 * 1985 % 10 = 5
 * 9985 / 10 =
 */
public class Tasks {
    public static void main(String[] args) {
        int result = calculateEvenNumbers(1885, 0);

//        System.out.println(result);
//        long gcd = gcd(12, 4);
        long gcd = gcd(18, gcd(12, 4));

//        System.out.println(gcd);

        boolean result1 = checkSequenceOnIncreasing(0, 6, 5, 9, 10);

        System.out.println(result1);
    }

    /**
     * 4.Дано 2 числа знайти найбільший спільний дільник 2 - х чисел.
     * В математике, наибольшего общего делителя (НОД)
     * двух ненулевых целых чисел, является крупнейшим положительное целое число,
     * которое делит оба номера.
     */

    public static int calculateEvenNumbers(int value, int count) {
        if ((value % 10) % 2 == 0) {
            ++count;
        }

        if (value < 10) {
            return count;
        }

        return calculateEvenNumbers(value / 10, count);
    }

    public static long gcd(long a, long b) {//12, 4
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);//4, 0
        }
    }

    /**
     * 4,5,9,10
     */

    public static boolean checkSequenceOnIncreasing(int index, int... array) {
        if (index >= array.length - 1) {
            return true;
        }

        if (array[index] > array[++index]) {
            return false;
        }

        return checkSequenceOnIncreasing(index, array);
    }

}
