package homeworks.dmytro_k.hw_2023.hw_15_10_23;

/**
 * Первый модуль приложения — управление сотрудниками.
 * ++У сотрудника есть имя, идентификатор сотрудника,
 * ++а также должность: рабочий, супервайзер, инженер.
 * Работники могут работать как на окладе, так и на условиях неполного рабочего времени.
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
    private double salary;
    private boolean fullTimeWork;
    private double hoursWorked;

    public Employee(String name, EmployeeType employeeType, boolean fullTimeWork) {
        this.name = name;
        this.id += countId;
        this.employeeType = employeeType;
        this.fullTimeWork = fullTimeWork;
        //this.salary = setSalary(employeeType);
    }

/*    private double setSalary(EmployeeType employeeType) {

        if (fullTimeWork) {
            if (employeeType.equals(EmployeeType.WORKER)) {
                return 408;
            } else if (employeeType.equals(EmployeeType.SUPERVISOR)) {
                return 788;
            } else if (employeeType.equals(EmployeeType.ENGINEER)) {
                return 700;
            }
        } else {
            if (employeeType.equals(EmployeeType.WORKER)) {
                return hoursWorked * 6 * 2;
            } else if (employeeType.equals(EmployeeType.SUPERVISOR)) {
                return hoursWorked * 5 * 2;
            } else if (employeeType.equals(EmployeeType.ENGINEER)) {
                return hoursWorked * 40 * 2;
            }
        }
    }*/
}
