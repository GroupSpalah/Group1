package homeworks.dmytro_k.hw_2024.hw_31_03_24.version2;

import java.util.HashSet;

/**
 * Не потокобезопасен и при записи в него или изменении данных в нем разными потоками должен быть синхронизирован извне.
 * Это не касается чтения данных из HashSet.
 */

public class BoundedHashSet<T> extends HashSet<T> {
    private final int maxSize;

    public BoundedHashSet(int maxSize) {
        super();
        this.maxSize = maxSize;
    }

    @Override
    public boolean add(T t) {
        if (size() >= maxSize) {
            return false;
        }
        return super.add(t);
    }
}
