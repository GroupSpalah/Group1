package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConstructionService {
    private List<ConstructionSite> constructionSites;

    public ConstructionService() {
        this.constructionSites = new ArrayList<>();
    }
    public void addConstruction(ConstructionSite constructionSite) {
        this.constructionSites.add(constructionSite);
    }
    public long getWorkersNumber(ConstructionSite constructionSite) {
        return constructionSite.getStaff().size();
    }
    public BigDecimal calculateStaffSalary(ConstructionSite constructionSite) {
        int subordinaryNumber = constructionSite.getStaff().size() - 1;
        return constructionSite.getStaff()
                .stream()
                .peek(element -> {
                    if (element.getPosition() == Position.SUPERVISOR) {
                        element.setSubordinaryNumber(subordinaryNumber);
                    }
                })
                .map(Employee::calculateSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
