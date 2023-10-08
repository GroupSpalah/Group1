package homeworks.sergii_khvostov.hw_2023.hw_01_10_23;

import java.util.List;
public class SeaPlatform {
    private String serialNumber;
    private List<Worker> workers;
    private int plannedProductivity;
    private int actualProductivity;
    private boolean hasError;

    public SeaPlatform(String serialNumber,List<Worker> workers, int plannedProductivity,
                       int actualProductivity, boolean hasError) {
        this.serialNumber = serialNumber;
        this.workers = workers;
        this.plannedProductivity = plannedProductivity;
        this.actualProductivity = actualProductivity;
        this.hasError = hasError;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public int getPlannedProductivity() {
        return plannedProductivity;
    }

    public int getActualProductivity() {
        return actualProductivity;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }
}
