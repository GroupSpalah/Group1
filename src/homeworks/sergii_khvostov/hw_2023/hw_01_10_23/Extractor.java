package homeworks.sergii_khvostov.hw_2023.hw_01_10_23;

public class Extractor {
    private String serialNumber;
    private int plannedProductivity;
    private int actualProductivity;
    private boolean hasError;
    private ExtractorType type;

    public Extractor(String serialNumber, int plannedProductivity, int actualProductivity,
                     boolean hasError, ExtractorType type) {
        this.serialNumber = serialNumber;
        this.plannedProductivity = plannedProductivity;
        this.actualProductivity = actualProductivity;
        this.hasError = hasError;
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getPlannedProductivity() {
        return plannedProductivity;
    }

    public int getActualProductivity() {
        return actualProductivity;
    }

    public boolean isHasError() {
        return hasError;
    }

    public ExtractorType getType() {
        return type;
    }
}

