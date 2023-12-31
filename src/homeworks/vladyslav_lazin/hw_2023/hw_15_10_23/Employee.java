package homeworks.vladyslav_lazin.hw_2023.hw_15_10_23;

import java.math.BigDecimal;

public class Employee {
    private static int currentId = 0;
    private int id;
    private String name;
    private int workedTime;
    private Position position;
    private boolean isPartTime;
    private int subordinaryNumber;

    public BigDecimal calculateSalary() {
        BigDecimal salary = null;
        if (this.position == Position.WORKER && this.isPartTime) {
            salary = new BigDecimal(Position.WORKER.getHourRate() * this.workedTime * 2);
        } else {
            salary = new BigDecimal(this.getPosition().getBaseSalary()
                    + this.getPosition().getHourRate() * this.workedTime + .5 * this.getSubordinaryNumber());
        }
        return salary;
    }

    public Employee(String name, Position position, boolean isOnPartTime, int workedTime) {
        this.id = currentId;
        currentId++;
        this.name = name;
        this.position = position;
        this.subordinaryNumber = 0;
        this.isPartTime = isOnPartTime;
        this.workedTime = workedTime;
    }

    public Position getPosition() {
        return position;
    }

    public int getWorkedTime() {
        return workedTime;
    }

    public int getSubordinaryNumber() {
        return subordinaryNumber;
    }

    public void setSubordinaryNumber(int subordinaryNumber) {
        if (this.position == Position.SUPERVISOR) {
            this.subordinaryNumber = subordinaryNumber;
        }
    }
    public void setWorkedTime(int workedTime) {
        this.workedTime = workedTime;
    }
}
