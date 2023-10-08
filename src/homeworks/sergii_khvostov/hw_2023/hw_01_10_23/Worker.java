package homeworks.sergii_khvostov.hw_2023.hw_01_10_23;

public class Worker {
    private String name;
    private WorkerRole role;
    private int daysOnPlatform;

    public Worker(String name, WorkerRole role, int daysOnPlatform) {
        this.name = name;
        this.role = role;
        this.daysOnPlatform = daysOnPlatform;
    }

    public String getName() {
        return name;
    }

    public int getDaysOnPlatform() {
        return daysOnPlatform;
    }
}
