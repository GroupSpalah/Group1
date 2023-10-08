package homeworks.dmytro_k.hw_2023.hw_01_10_23.task1;

/**
 * Все экстракторы имеют серийный номер,
 * предполагаемую производительность (сколько они способны извлечь за 24 часа) и количество
 * (сколько они фактически извлекли за 24 часа). Кроме того, некоторые экстракторы могут сообщать о
 * каких-либо сбоях за последние 24 часа.
 */

public abstract class Extractor {
    private int serialNumb;
    private static int counterSNumbs = 1;
    private ExtractorType extractorType;
    private int expectedPerformance;
    private int quantity;
    private final String ERROR_MESSAGE = "error";

    public Extractor(ExtractorType extractorType, int expectedPerformance, int quantity) {
        this.serialNumb = counterSNumbs++;
        this.extractorType = extractorType;
        this.expectedPerformance = expectedPerformance;
        this.quantity = quantity;
    }

    public ExtractorType getExtractorType() {
        return extractorType;
    }

    public void setExtractorType(ExtractorType extractorType) {
        this.extractorType = extractorType;
    }

    public int getExpectedPerformance() {
        return expectedPerformance;
    }

    public void setExpectedPerformance(int expectedPerformance) {
        this.expectedPerformance = expectedPerformance;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getERROR_MESSAGE() {
        return ERROR_MESSAGE;
    }

    public String errorMessage(String errorNumber) {
        return "Extractor{" +
                "serialNumb=" + serialNumb +
                ", extractorType=" + extractorType +
                ", ERROR_MESSAGE='" + ERROR_MESSAGE + errorNumber + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Extractor{" +
                "serialNumb=" + serialNumb +
                ", extractorType=" + extractorType +
                ", expectedPerformance=" + expectedPerformance +
                ", quantity=" + quantity + '\'' +
                '}';
    }
}
