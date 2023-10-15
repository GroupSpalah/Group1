package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;

import java.util.List;

public final class Conference extends Event {
    private int totalGiftBags;

    public Conference(List<Employee> staff, int totalGiftBags) {
        super(staff);
        this.totalGiftBags = totalGiftBags;
    }
}
