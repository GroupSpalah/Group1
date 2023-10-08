package homeworks.vladyslav_lazin.hw_2023.hw_01_10_23;

import java.util.List;

public abstract class OilExtractor {
    private String serialNumber;
    private int dailyExtractionRate;
    private int extractedPerDay;

    private boolean hasErrors = false;

    public OilExtractor(String serialNumber, int dailyExtractionRate, int extractedPerDay) {
        this.serialNumber = serialNumber;
        this.dailyExtractionRate = dailyExtractionRate;
        this.extractedPerDay = extractedPerDay;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getDailyExtractionRate() {
        return dailyExtractionRate;
    }

    public int getExtractedPerDay() {
        return extractedPerDay;
    }
    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }
}
