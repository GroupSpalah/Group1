package homeworks.dmytro_k.hw_2023.hw_15_10_23;

public enum ConstructionSiteType {

    RESIDENTIAL_BUILDING(10000),
    APARTMENT_BUILDING(1000000),
    OFFICE_BUILDING(2000000);

    private final int time;

    ConstructionSiteType(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return '{' + "time = " + time +
                '}';
    }
}
