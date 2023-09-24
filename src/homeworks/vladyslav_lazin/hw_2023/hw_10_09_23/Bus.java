package homeworks.vladyslav_lazin.hw_2023.hw_10_09_23;

import java.time.LocalDate;

public class Bus extends Vehicle{
private int contaminationIndicator;

    public Bus(String licensePlate, int capacity, Condition condition, LocalDate lastService, int contaminationIndicator) {
        super(licensePlate, capacity, lastService);
        this.contaminationIndicator = contaminationIndicator;
        this.setFuelType(FuelType.GAS);
        setCondition(this.getLastService(), this.contaminationIndicator);
    }
    public void setCondition(LocalDate lastService, int contaminationIndicator) {
        int timeArterService = LocalDate.now().getMonth().getValue() - lastService.getMonth().getValue();
        if (timeArterService <= 6 && contaminationIndicator > 5) {
            this.setCondition(Condition.IN_OPERATION);
        } else if (timeArterService <= 12 && contaminationIndicator >= 3 && contaminationIndicator <= 6)  {
            this.setCondition(Condition.NEEDS_REPAIRS);
        } else {
            this.setCondition(Condition.SCRAPPED);
        }
    }
}
