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

public class OffshorePlatforms extends Extractor {

    private List<Employee> employees;
    private static final ExtractorType EXTRACTOR_TYPE = ExtractorType.OFFSHORE_PLATFORMS;
    private static final int MAX_DAY = 14;

    public OffshorePlatforms(int expectedPerformance, int quantity) {
        super(EXTRACTOR_TYPE, expectedPerformance, quantity);
        this.employees = new LinkedList<>();
        //error();//?
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    Predicate<Employee> postMedic = element -> element.getPost().equals(Post.MEDIC);
    Predicate<Employee> dayOnBoard = element -> element.getWorkDays() > MAX_DAY;

    public void error() {
        if (getQuantity() < getExpectedPerformance() * 0.7) {
            errorMessage(" (2)");
        } else if (employees
                .stream()
                .noneMatch(postMedic)) {
            errorMessage(" (3)");
        } else if (employees
                .stream()
                .anyMatch(dayOnBoard)) {
            errorMessage(" (4)");
        }
    }
}
