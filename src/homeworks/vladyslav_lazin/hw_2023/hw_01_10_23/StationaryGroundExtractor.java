package homeworks.vladyslav_lazin.hw_2023.hw_01_10_23;

import java.util.Map;

public class StationaryGroundExtractor extends OilExtractor{
    private final Map<Placement, Double> placement;

    public StationaryGroundExtractor(String serialNumber, int dailyExtractionRate,
                                     int extractedPerDay, Map<Placement, Double> placement) {
        super(serialNumber, dailyExtractionRate, extractedPerDay);
        this.placement = placement;
    }
}
