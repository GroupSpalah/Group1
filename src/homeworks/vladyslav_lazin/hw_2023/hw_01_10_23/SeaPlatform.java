package homeworks.vladyslav_lazin.hw_2023.hw_01_10_23;

import java.util.LinkedList;
import java.util.List;

public class SeaPlatform extends OilExtractor implements Reportable{
    private final List<Worker> crew;

    public SeaPlatform(String serialNumber, int dailyExtractionRate, int extractedPerDay,
                       List<Worker> crew) {
        super(serialNumber, dailyExtractionRate, extractedPerDay);
        this.crew = crew;
        this.checkErrors();
    }

    @Override
    public void checkErrors() {
        if (this.getCrew()
                .stream()
                .anyMatch(worker -> worker.timeAboard() > 14)
        || this.getCrew()
                .stream().
                noneMatch(worker -> worker.position() == Position.MEDIC)
        || this.getExtractedPerDay() < .7 * this.getDailyExtractionRate()) {
            this.setHasErrors(true);
        }
    }

    public List<Worker> getCrew() {
        return crew;
    }
}
