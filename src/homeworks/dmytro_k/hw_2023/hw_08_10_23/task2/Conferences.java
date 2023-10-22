package homeworks.dmytro_k.hw_2023.hw_08_10_23.task2;

import java.util.List;

/**
 * На конференциях гости могут попросить подарочную сумку, но только одну на каждого гостя.
 */

public class Conferences extends Event {

    private final int BAG = 1;//?

    public Conferences() {
        super(EventType.CONFERENCES);
    }

    public int getBAG() {
        return BAG;
    }
}
