package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

import java.util.ArrayList;
import java.util.List;

public final class ConstructionSite {
    private int estimatedTime;
    private BuildingType buildingType;
    private List<Employee> staff;

    public ConstructionSite(BuildingType buildingType) {
        this.buildingType = buildingType;
        switch (this.buildingType) {
            case HOUSE -> this.estimatedTime = 10000;
            case APARTMENT_HOUSE -> this.estimatedTime = 1000000;
            case OFFICE_BUILDING -> this.estimatedTime = 2000000;
        }
        this.staff = new ArrayList<>();
    }

    public List<Employee> getStaff() {
        return staff;
    }

    public void addEmployeeToStaff(Employee employee) {
        boolean sectionChiefExixts =
                this.staff.stream().anyMatch(element -> element instanceof SectionChief);
        if (!sectionChiefExixts) {
            this.staff.add(employee);
        }

    }
}
