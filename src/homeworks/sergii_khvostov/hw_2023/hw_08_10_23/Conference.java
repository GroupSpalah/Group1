package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;


import java.util.HashSet;
import java.util.Set;

public class Conference extends Event {

    private Set<Visitor> visitors;
    private long numBagsTaken;

    public Conference() {
        super(EventType.CONFERENCE);
        this.visitors = new HashSet<>();
    }

    public long getNumBagsTaken() {
        return numBagsTaken;
    }


    public boolean takeBag(Visitor visitor) {
        if (getNumBagsTaken() < visitors.size() && !visitors.contains(visitor)) {
            numBagsTaken++;
            visitors.add(visitor);
            return true;
        }
        return false;
    }

    @Override
    public boolean canEventStart() {
        long helper = getEmployees().stream()
                .filter(employee -> employee.role() == EmployeeRole.HELPER)
                .count();
        long organizer = getEmployees().stream()
                .filter(employee -> employee.role() == EmployeeRole.ORGANIZER)
                .count();
        return helper >= 10 && organizer >= 3 && numBagsTaken >= visitors.size();
    }
}

