package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

import java.math.BigDecimal;

public class Employee {
    private static int currentId = 0;
    private int id;
    private String name;
    private Employment employment;
    private Position position;
    private int subordinaryNumber;

    public BigDecimal calculateSalary(int hoursNumber) {
        BigDecimal salary = null;
        if (this.position == Position.WORKER && this.employment == Employment.PART_TIME) {
            salary = new BigDecimal(Position.WORKER.getHourRate() * hoursNumber * 2);
        } else {
            salary = new BigDecimal(this.getPosition().getBaseSalary()
                    + this.getPosition().getHourRate() * hoursNumber + .5 * this.getSubordinaryNumber());
        }
        return salary;
    }

    public Employee(String name, Position position, Employment employment) {
        this.id = currentId;
        currentId++;
        this.name = name;
        this.position = position;
        this.employment = employment;
        this.subordinaryNumber = 0;
    }

    /**
     * @param name - String
     * @param subordinaryNumber - int, subordinary workers number, only for supervisers
     */
    public Employee(String name, int subordinaryNumber) {
        this.id = currentId;
        currentId++;
        this.name = name;
        this.position = Position.SUPERVISOR;
        this.employment = Employment.FULL_TIME;
        this.subordinaryNumber = subordinaryNumber;
    }

    public Position getPosition() {
        return position;
    }

    public int getSubordinaryNumber() {
        return subordinaryNumber;
    }

    public void setSubordinaryNumber(int subordinaryNumber) {
        this.subordinaryNumber = subordinaryNumber;
    }
}
