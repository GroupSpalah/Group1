package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

import java.math.BigDecimal;

public class ConstructionService {
    public long getWorkersNumber(ConstructionSite constructionSite) {
        return constructionSite.getStaff().size();
    }
    public BigDecimal calculateStaffSalary(ConstructionSite constructionSite, int workTime) {

        return constructionSite.getStaff()
                .stream()
                .map(element -> element.calculateSalary(workTime))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
