package homeworks.vladyslav_lazin.hw_2023.hw_10_09_23;

import java.time.LocalDate;

public class Bus extends Vehicle{
private int contaminationIndicator;

    public Bus(String licensePlate, int capacity, LocalDate lastService, int contaminationIndicator) {
        super(licensePlate, capacity, lastService);
        this.contaminationIndicator = contaminationIndicator;
        this.licensePlate = licensePlate;
        this.condition = setCondition(this.getLastService(), this.contaminationIndicator);
    }
    public Condition setCondition(LocalDate lastService, int contaminationIndicator) {
        Condition condition;
        int timeArterService = LocalDate.now().getMonth().getValue() - lastService.getMonth().getValue();
        if (timeArterService <= 6 && contaminationIndicator > 5) {
            condition = Condition.IN_OPERATION;
        } else if (timeArterService <= 12 && contaminationIndicator >= 3 && contaminationIndicator <= 6)  {
            condition = Condition.NEEDS_REPAIRS;
        } else {
            condition = Condition.SCRAPPED;
        }
        return condition;
    }
}
