package homeworks.dmytro_k.hw_2023.hw_08_10_23.task2;

import java.util.List;

public class Wedding extends Event {
    private boolean isCake;

    public Wedding(boolean isCake) {
        super(EventType.WEDDINGS);
        this.isCake = isCake;
    }

    public boolean isStart() {
        return super.isStart() && isCake;
    }
}
