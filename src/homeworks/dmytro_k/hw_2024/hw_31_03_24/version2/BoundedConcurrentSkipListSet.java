package homeworks.dmytro_k.hw_2024.hw_31_03_24.version2;

import java.util.Comparator;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Предпочтительнее для использования в многопоточной среде, потому что является потокобезопасным,
 * но метод size() работает относительно медленно в ConcurrentSkipListSet.
 * Это происходит в результате того, что он не хранит свой размер в отдельном поле и метод size()
 * проходит по всем элементам, чтобы вернуть их количество.
 * Вызов этого метода может быть дорогим для больших наборов данных.
 */
public class BoundedConcurrentSkipListSet<T> extends ConcurrentSkipListSet<T> {
    private final int maxSize;

    public BoundedConcurrentSkipListSet(int maxSize, Comparator<? super T> comparator) {
        super(comparator);
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