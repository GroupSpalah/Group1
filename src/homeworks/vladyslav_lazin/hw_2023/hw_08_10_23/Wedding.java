package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;

import java.util.List;

public class Wedding extends Event {
    private boolean hasWeddingCake;


    public Wedding(List<Employee> staff) {
        super(staff);
        this.hasWeddingCake = true;
    }
}
