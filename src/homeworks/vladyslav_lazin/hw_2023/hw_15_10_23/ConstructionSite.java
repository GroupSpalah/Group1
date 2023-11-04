package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

import java.util.ArrayList;
import java.util.List;

public final class ConstructionSite {
    private final BuildingType buildingType;
    private List<Employee> staff;

    public ConstructionSite(BuildingType buildingType) {
        this.buildingType = buildingType;
        this.staff = new ArrayList<>();
    }

    public List<Employee> getStaff() {
        return staff;
    }
    public Boolean isInProgress() {
        return this.staff.stream()
                .anyMatch(element -> element.getPosition() == Position.SUPERVISOR);
    }
    public void addEmployeeToStaff(Employee employee) {
        if (employee.getPosition() == Position.SUPERVISOR) {
            if(!this.isInProgress()) {
                this.staff.add(employee);
            }
        } else {
            this.staff.add(employee);
        }
    }
}
