package homeworks.dmytro_k.hw_2023.hw_15_10_23;

/**
 * Первый модуль приложения — управление сотрудниками.
 * ++У сотрудника есть имя, идентификатор сотрудника,
 * ++а также должность: рабочий, супервайзер, инженер.
 * ++Работники могут работать как на окладе, так и на условиях неполного рабочего времени.
 * Работники получают заработную плату в деньгах на основе следующих правил:
 * <p>
 * Рабочие получают базовую заработную плату в размере 408$ и 6$ за отработанные часы.
 * <p>
 * Супервайзеры получают базовую зарплату в размере 788$, 5$ в час
 * плюс 0,5$ за каждого рабочего, которого они контролируют.
 * <p>
 * Инженеры получают базовую оплату в размере 700$ и 40$ в час.
 * Работники, занятые неполный рабочий день, не получают
 * базовую заработную плату, но получают двойную почасовую ставку по найму.
 */

public class Employee {
    private String name;
    private int id;
    private static final int countId = 1;
    private EmployeeType employeeType;
    private float salary;
    private boolean fullTimeWork;
    private double hoursWorked;

    public Employee(String name, EmployeeType employeeType, boolean fullTimeWork) {
        this.name = name;
        this.id += countId;
        this.employeeType = employeeType;
        this.fullTimeWork = fullTimeWork;
        if (fullTimeWork) {
            this.salary = employeeType.getBaseSalary();
        } else {
            this.salary = employeeType.getHourSalary() * 2;
        }
    }

    public void setSupervisorSalary() {

/*        if (employeeType.equals(EmployeeType.SUPERVISOR)) {
            salary +=
        }*/
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isFullTimeWork() {
        return fullTimeWork;
    }

    public void setFullTimeWork(boolean fullTimeWork) {
        this.fullTimeWork = fullTimeWork;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
