package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

public enum Position {
    WORKER(408, 6),
    SUPERVISOR(788, 5),
    SECTION_CHIEF(700, 40);

    Position(float baseSalary, float hourRate) {
        this.baseSalary = baseSalary;
        this.hourRate = hourRate;
    }

    private float baseSalary;
    private float hourRate;

    public float getBaseSalary() {
        return baseSalary;
    }

    public float getHourRate() {
        return hourRate;
    }
}
