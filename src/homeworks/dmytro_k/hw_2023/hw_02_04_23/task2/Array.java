package homeworks.dmytro_k.hw_2023.hw_02_04_23.task2;

public class Array <T> {

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
