package homeworks.dmytro_m.hw_2023.hw_02_04_2023.task1;

public class ArrayWorker<T extends Number> {
    private T[] arr;
    private T num;

    public ArrayWorker(T[] arr, T num) {
        this.arr = arr;
        this.num = num;
    }

    public int countNumber(T[] arr, T num) {

        int count = 0;

        for (T i : arr) {
            if (num.doubleValue() > i.doubleValue()) {
                count++;
            }
        }
        return count;
    }
}
//    Создайте общий класс ArrayWorker с общим полем массива для работы
// * Целое и двойное
//         * Добавьте код для подсчета количества элементов в каждом из массивов, которые больше
//         * чем указанный элемент.