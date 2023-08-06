package homeworks.sergii_khvostov.hw_2023.hw_02_04_23;

/*Create a generic class ArrayWorker with generic array field for working Integer and Double
Add code to counts the number of elements in each of arrays that are greater
than a specified element.*/

public class ArrayWorker<T extends Number> {
    private final T[] array;

    public ArrayWorker(T[] array) {
        this.array = array;
    }

    public int countGreaterThan(T value) {
        int count = 0;

        for (T element : array) {
            if (element.doubleValue() > value.doubleValue()) {
                count++;
            }
        }
        return count;
    }
}
