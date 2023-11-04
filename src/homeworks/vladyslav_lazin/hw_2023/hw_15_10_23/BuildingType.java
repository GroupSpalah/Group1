package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

public enum BuildingType {
    HOUSE(10000),
    APARTMENT_HOUSE(100000),
    OFFICE_BUILDING(200000);

    private int estimatimatedTime;

    BuildingType(int estimatimatedTime) {
        this.estimatimatedTime = estimatimatedTime;
    }

    public int getEstimatimatedTime() {
        return estimatimatedTime;
    }
}
