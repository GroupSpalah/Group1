package homeworks.dmytro_k.hw_2023.hw_01_10_23.task1;

/**
 * Все экстракторы имеют серийный номер,
 * предполагаемую производительность (сколько они способны извлечь за 24 часа) и количество
 * (сколько они фактически извлекли за 24 часа). Кроме того, некоторые экстракторы могут сообщать о
 * каких-либо сбоях за последние 24 часа.
 */

public abstract class Extractor {
    private int serialNumber;
    private static int counterSNumbs = 1;
    private ExtractorType extractorType;
    private double expectedPerformance;
    private double quantity;
    private boolean error;//v1
    private Status status;//v2

    public Extractor(ExtractorType extractorType, double expectedPerformance, double quantity) {
        this.serialNumber = counterSNumbs++;
        this.extractorType = extractorType;
        this.expectedPerformance = expectedPerformance;
        this.quantity = quantity;
        this.error = false;
        this.status = Status.WORK;
    }

    public double getExpectedPerformance() {
        return expectedPerformance;
    }

    public double getQuantity() {
        return quantity;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Status getStatus() {
        return status;
    }

    public void error2() { // v2
        this.status = Status.ERROR;
    }

    @Override
    public String toString() {
        return "Extractor{" +
                "serialNumb=" + serialNumber +
                ", extractorType=" + extractorType +
                ", expectedPerformance=" + expectedPerformance +
                ", quantity=" + quantity + '\'' +
                '}';
    }
}
