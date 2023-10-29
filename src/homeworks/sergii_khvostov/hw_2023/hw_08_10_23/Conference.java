package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Conference extends Event {

    private long helperCount;
    private long organizerCount;
    private Set<Visitor> visitors;
    private long numBagsTaken;


    public Conference(EventType type, List<Employee> employees,
                      long helperCount, long organizerCount) {
        super(type, employees);
        this.helperCount = helperCount;
        this.organizerCount = organizerCount;
        this.visitors = new HashSet<>();
        addEvent();
    }

    public boolean takeBag(Visitor visitor) {
        if (numBagsTaken < visitors.size() && !visitors.contains(visitor)) {
            numBagsTaken++;
            visitors.add(visitor);
            return true;
        }
        return false;
    }

    @Override
    public boolean canEventStart() {
        return helperCount >= 10 && organizerCount >= 3 && numBagsTaken == visitors.size();
    }
}

