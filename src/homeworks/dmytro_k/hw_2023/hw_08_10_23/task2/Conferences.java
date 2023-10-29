package homeworks.dmytro_k.hw_2023.hw_08_10_23.task2;

import java.util.HashMap;
import java.util.Map;

/**
 * На конференциях гости могут попросить подарочную сумку, но только одну на каждого гостя.
 */

public class Conferences extends Event {

    private Map<Visitor, Boolean> visitorBag;

    public Conferences() {
        super(EventType.CONFERENCES);
        visitorBag = new HashMap<>();
    }

    public void setVisitorBag(Visitor visitor) {
        if (visitorBag.get(visitor).equals(true)) {
            System.out.println("you have bag");
        } else {
            visitorBag.put(visitor, true);
        }
    }
}
