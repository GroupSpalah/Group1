package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

public class Employee {
    private int currentId = 0;
    private int id;
    private String name;
    private Position position;
    private Employment employment;

    public Employee(int currentId, String name, Position position, Employment employment) {
        this.id = currentId;
        currentId++;
        this.name = name;
        this.position = position;
        this.employment = employment;
    }
}
