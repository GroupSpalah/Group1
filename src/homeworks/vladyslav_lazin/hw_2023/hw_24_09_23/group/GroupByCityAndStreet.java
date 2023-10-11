package homeworks.vladyslav_lazin.hw_2023.hw_24_09_23.group;

public record GroupByCityAndStreet(String city, String street) {
    @Override
    public String toString() {
        return city + ", " + street;
    }
}
