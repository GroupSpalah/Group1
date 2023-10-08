package homeworks.dmytro_k.hw_2023.hw_01_10_23.task1;

/**
 * У работника есть имя, должность (рабочий, медик или менеджер) и количество дней,
 * которое он провел на платформе.
 */

public class Employee {
    private String name;
    private Post post;
    private int workDays;

    public Employee(String name, Post post, int workDays) {
        this.name = name;
        this.post = post;
        this.workDays = workDays;
    }

    public Post getPost() {
        return post;
    }

    public int getWorkDays() {
        return workDays;
    }
}
