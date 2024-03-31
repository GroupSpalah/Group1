package homeworks.dmytro_k.hw_2024.hw_17_03_24.task1;

import java.util.List;
import java.util.stream.IntStream;

public class RandomizerService {

    private static final int INDEX_OFFSET = 1;

    public void startThreadMaker(List<Randomizer> randomizers) {
        int numberOfRandomizers = randomizers.size();
        Thread[] threads = new Thread[numberOfRandomizers];

        IntStream.range(0, numberOfRandomizers)
                .forEach(i -> {
                    int from = randomizers.get(i).from();
                    int upTo = randomizers.get(i).upTo();
                    long streamSize = randomizers.get(i).streamSize();
                    int sleepTime = randomizers.get(i).sleepTime();

                    Randomizer randomizer = new Randomizer(from, upTo, streamSize, sleepTime);
                    threads[i] = new Thread(randomizer, "Thread " + (i + INDEX_OFFSET));
                    threads[i].start();
                });
    }
}
