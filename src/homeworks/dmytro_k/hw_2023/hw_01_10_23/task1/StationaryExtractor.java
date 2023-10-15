package homeworks.dmytro_k.hw_2023.hw_01_10_23.task1;

/**
 * 1.)Стационарные наземные экстракторы устанавливаются в месте,
 * которое не может измениться после первоначальной настройки.
 * Они не могут сообщать об ошибках.
 */

public class StationaryExtractor extends Extractor {

    private static final ExtractorType EXTRACTOR_TYPE = ExtractorType.STATIONARY;

    public StationaryExtractor(double expectedPerformance, double quantity) {
        super(EXTRACTOR_TYPE, expectedPerformance, quantity);
    }
}
