package homeworks.dmytro_k.hw_2023.hw_02_04_23.task2;

/**
 * Suppose we have the next generic class:
 * <p>
 * In the class ArrayUtil write static
 * method named "averageValue(...)" that
 * takes an object of Array type as input,
 * and returns the average value its
 * elements The given method should
 * returns value of double type and take
 * any array, whose elements extends
 * Number type
 * <p>
 * Examples of usage:
 * <p>
 * //Print to display:
 * Array <Integer> set1 new Array<>(new Integer[] {1, 2, 4, 5});
 * double averageValue1 ArrayUti1.averageValue(set);
 * System.out.println(averageValue1).
 * <p>
 * //Print to display:
 * Array <Double> set2 new Array<> (new Double[] {1.0, 3.0, 5.0});
 * double averageValue2 = ArrayUtil.averageValue (set2);
 * System.out.println (averageValue2);
 * <p>
 * pick correct passing of all rests don`t use print and println methods in your code
 **/

public class ArrayUtil {

    public static <T extends Number> double averageValue(T[] array) {

        double sum = 0;

        for (T e : array) {
            sum = e.doubleValue() + sum;
        }

        return sum / array.length;
    }

    public static <T extends Number> double averageValue(Array<T> array) {

        double sum = 0;

        for (int i = 0; i < array.length(); i++) {
            double value = array.get(i).doubleValue();
            sum = value + sum;
        }

        return sum / array.length();
    }
}
