package lessons.generic;

/**
 * Create class MyTestMethod with generic static method calcNum (with two parameters: an array T[] and
 * variable maxElem of type T) that counts the number of elements in
 * an array T[] that are greater than a specified element maxElem.
 */

public class Task1 {
    public static void main(String[] args) {

        Integer[] array = {4, 8, 6, 9};

        int count = MyTestMethod.calcNum(array, 5);

        System.out.println(count);
    }
}

class MyTestMethod {
    public static  <T extends Number> int calcNum(T[] array, T maxElem) {

        int count = 0;

        for (T e : array) {
            if (e.doubleValue() > maxElem.doubleValue()) {
                ++count;
            }
        }

        return count;
    }
}