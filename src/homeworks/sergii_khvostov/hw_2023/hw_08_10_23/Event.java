package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;

import java.util.List;

public record Event(EventType type, List<Employee> employees, boolean hasCake, boolean hasBags) {
}
