package homeworks.dmytro_k.hw_2023.hw_02_04_23.task1;

/**
 * 1) Create a generic class ArrayWorker with generic array field for working
 * Integer and Double
 * Add code to counts the number of elements in each of arrays that are greater
 * than a specified element.
 **/

public class ArrayWorker {

    public static <T extends Number> int calcNum(T[] array, T element) {

        int count = 0;

        for (T e : array) {
            if (e.doubleValue() > element.doubleValue())
                count++;
        }

        return count;
    }
}
