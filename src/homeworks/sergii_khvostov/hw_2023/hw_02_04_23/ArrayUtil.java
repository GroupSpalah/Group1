package homeworks.sergii_khvostov.hw_2023.hw_02_04_23;

/*Suppose we have the next generic class:

class Array<T> {
private T[] array;

public Array(T[] array) {
this.array = array;
}

public T get(int index) {
return array[index];
}

public int length() {
return array.length;
 }
}

In the class ArrayUtil write static method named "averageValue(...)" that takes
an object of array type as input, and returns the average value its element.
The given method should return value doubles type and take any array, whose
element extends Number type.
*/

public class ArrayUtil {

    public static double averageValue(Number[] array) {
        double sum = 0.0;

        for (Number num : array) {
            sum += num.doubleValue();
        }
        return sum / array.length;
    }
}
