package homeworks.dmytro_k.hw_2024.hw_17_03_24.task1;

import java.util.List;

public class RandomizerTest {
    public static void main(String[] args) {
        Randomizer randomizer1 = new Randomizer(10, 30, 3, 3);
        Randomizer randomizer2 = new Randomizer(50, 100, 3, 3);

        List<Randomizer> randomizers = List.of(randomizer1, randomizer2);

        RandomizerService randomizerService = new RandomizerService();
        randomizerService.startThreadMaker(randomizers);
    }
}
