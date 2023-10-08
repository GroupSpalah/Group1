package homeworks.vladyslav_lazin.hw_2023.hw_01_10_23;

import java.util.Map;

public class MobileGroundExtractor extends OilExtractor implements Reportable{
    private Map<Placement, Double> placement;


    public MobileGroundExtractor(String serialNumber, int dailyExtractionRate, int extractedPerDay, Map<Placement, Double> placement) {
        super(serialNumber, dailyExtractionRate, extractedPerDay);
        this.checkErrors();
    }

    @Override
    public void checkErrors() {
        this.setHasErrors(this.getExtractedPerDay() < .25 * this.getDailyExtractionRate());
    }
}
