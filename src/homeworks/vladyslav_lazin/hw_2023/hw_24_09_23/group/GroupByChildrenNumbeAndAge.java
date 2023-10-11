package homeworks.vladyslav_lazin.hw_2023.hw_24_09_23.group;

public record GroupByChildrenNumbeAndAge(int childrenNumber, int age) {
    @Override
    public String toString() {
        return "Children Number: " + childrenNumber +
                ", age: " + age;
    }
}
