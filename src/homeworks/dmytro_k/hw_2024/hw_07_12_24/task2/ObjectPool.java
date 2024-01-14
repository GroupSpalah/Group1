package homeworks.dmytro_k.hw_2024.hw_07_12_24.task2;

import java.util.ArrayList;
import java.util.List;

public class ObjectPool<T> {

    private List<Human> pool;

    public ObjectPool(int size) {
        pool = new ArrayList<>(size);

    }
}
