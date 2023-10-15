package homeworks.dmytro_k.hw_2023.hw_01_10_23.task1;

/**
 * 2)Мобильные наземные экстракторы могут менять местоположение после его установки.
 * ++ Они сообщают об ошибке, если ежедневный объем
 * извлечения составляет менее 25% от производительности.(1)
 */

public class MobileExtractor extends Extractor {

    private static final ExtractorType EXTRACTOR_TYPE = ExtractorType.MOBILE;
    private static final double MIN_PERCENT = 0.25;

    public MobileExtractor(double expectedPerformance, double quantity) {
        super(EXTRACTOR_TYPE, expectedPerformance, quantity);
    }

    public void mobileExtractorError() {//проверить
        if (getQuantity() < getExpectedPerformance() * MIN_PERCENT) {
            this.setError(true);
        }
    }

    public void mobileExtractorError2() {//проверить
        if (getQuantity() < getExpectedPerformance() * MIN_PERCENT) {
            error2();
        }
    }
}
