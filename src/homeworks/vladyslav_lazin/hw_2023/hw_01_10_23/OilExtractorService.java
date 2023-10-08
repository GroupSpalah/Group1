package homeworks.vladyslav_lazin.hw_2023.hw_01_10_23;

import java.util.List;

public class OilExtractorService {
//Каково количество экстракторов с активными неисправностями?
public long inspectForErrors(List<OilExtractor> oilExtractors) {
    return oilExtractors.stream().filter(OilExtractor::isHasErrors).count();
}

public List<OilExtractor> findBestExtracors(List<OilExtractor> oilExtractors) {
    return oilExtractors
            .stream()
            .filter(oilExtractor -> oilExtractor.getExtractedPerDay() > .95 *
                    oilExtractor.getDailyExtractionRate()).toList();
}
}
