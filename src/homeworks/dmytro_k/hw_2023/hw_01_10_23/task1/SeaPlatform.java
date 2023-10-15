package homeworks.dmytro_k.hw_2023.hw_01_10_23.task1;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 3)Морские платформы устанавливаются в море (у них нет местоположения)
 * ++ и имеют список основных рабочих.
 * ++ У работника есть имя, должность (рабочий, медик или менеджер) и количество дней,
 * которое он провел на платформе.
 * ++ Все платформы сообщают об ошибке, если они извлекли менее 70% от запланированной мощности,
 * ++ у них нет медика
 * ++ или кто-либо из рабочих находится на борту более 14 дней.
 */

public class SeaPlatform extends Extractor {

    private List<Employee> employees;
    private static final ExtractorType EXTRACTOR_TYPE = ExtractorType.SEA_PLATFORMS;
    private static final int MAX_DAY = 14;

    public SeaPlatform(double expectedPerformance, double quantity) {
        super(EXTRACTOR_TYPE, expectedPerformance, quantity);
        this.employees = new LinkedList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    Predicate<Employee> postMedic = element -> element.getPost().equals(Post.MEDIC);
    Predicate<Employee> dayOnBoard = element -> element.getWorkDays() > MAX_DAY;

    public void seaPlatformError() {//проверить
        if (getQuantity() < getExpectedPerformance() * 0.7
                || employees
                .stream()
                .noneMatch(postMedic)
                || employees
                .stream()
                .anyMatch(dayOnBoard)) {
            this.setError(true);
        }
    }

    public void seaPlatformError2() {
        if (getQuantity() < getExpectedPerformance() * 0.7
                || employees
                .stream()
                .noneMatch(postMedic)
                || employees
                .stream()
                .anyMatch(dayOnBoard)) {
            error2();
        }
    }
}
