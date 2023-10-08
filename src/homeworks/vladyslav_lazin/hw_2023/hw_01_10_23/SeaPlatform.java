package homeworks.vladyslav_lazin.hw_2023.hw_01_10_23;

import java.util.LinkedList;
import java.util.List;

public class SeaPlatform extends OilExtractor implements Reportable{
    private List<Worker> crew = new LinkedList<>();

    public SeaPlatform(String serialNumber, int dailyExtractionRate, int extractedPerDay,
                       List<Worker> crew) {
        super(serialNumber, dailyExtractionRate, extractedPerDay);
        this.crew = crew;
        this.checkErrors();
    }

    @Override
    public void checkErrors() {
        if (this.getCrew().stream().filter(worker -> worker.position() == Position.MEDIC).toList().isEmpty()
        || !this.getCrew().stream().filter(worker -> worker.timeAboard() > 14).toList().isEmpty()
        || this.getExtractedPerDay() < .7 * this.getDailyExtractionRate()) {
            this.setHasErrors(true);
        }
    }

    public List<Worker> getCrew() {
        return crew;
    }
}
