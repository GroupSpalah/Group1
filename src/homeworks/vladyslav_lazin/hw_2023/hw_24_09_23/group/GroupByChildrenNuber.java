package homeworks.vladyslav_lazin.hw_2023.hw_24_09_23.group;

public record GroupByChildrenNuber(int childrenNumber) {
    @Override
    public String toString() {
        return "childrenNumber: " + childrenNumber;
    }
}
