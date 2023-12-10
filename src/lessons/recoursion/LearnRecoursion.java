package lessons.recoursion;

public class LearnRecoursion {
    private static int[] array = {5, 7, 9, 10, 6, 3};

    public static void printArrayByRecoursion(int j) {//5
        if (j == 0) {
            return;
        }

        System.out.print(array[j - 1] + " ");// 5 6
        printArrayByRecoursion(j - 1);//4
    }

    //5! = 1 * 2 * 3 * 4 * 5 = 120

    public static long calculateFactorial(int n) {
        if (n == 2) {
            return 2;
        }

        return calculateFactorial(n - 1) * n;
    }

    /**
     * 1) calculateFactorial(4) * 5 = 24 * 5
     * 2) calculateFactorial(3) * 4 = 6 * 4
     * 3) calculateFactorial(2) * 3 =  2 * 3
     * 4) calculateFactorial(2) -> 2
     */

    public static void printNumbersBetweenTwoNumbers(int a, int b) {//10, 20
        if (a == b) {
            System.out.print(a + " ");
            return;
        }

        System.out.print(a + " ");
        printNumbersBetweenTwoNumbers(++a, b);
    }

    public static void main(String[] args) {
//        printArrayByRecoursion(array.length);
//        printNumbersBetweenTwoNumbers(10, 20);
    }
}
