package homeworks.sergii_khvostov.hw_2023.hw_01_10_23;

import java.util.List;
import java.util.stream.Collectors;

public class OilExtractorManager {
    public long countFaultyExtractors(List<Extractor> extractors) {
        return extractors.stream()
                .filter(Extractor::isHasError)
                .count();
    }

    public List<Extractor> findHighPerformanceExtractors(List<Extractor> extractors) {
        return extractors.stream()
                .filter(extractor -> (double) extractor.getActualProductivity() /
                        extractor.getPlannedProductivity() > 0.95)
                .collect(Collectors.toList());
    }

    public void checkSeaPlatformErrors(List<SeaPlatform> seaPlatforms) {
        for (SeaPlatform platform : seaPlatforms) {
            double productivityRatio = (double) platform.getActualProductivity() / platform.getPlannedProductivity();
            boolean workerOverstay = platform.getWorkers().stream()
                    .anyMatch(worker -> worker.getDaysOnPlatform() > 14);

            if (productivityRatio < 0.7 || workerOverstay) {
                platform.setHasError(true);
            }
        }
    }
}
