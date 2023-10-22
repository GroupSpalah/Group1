package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;

/**
 *
 */
public class Employee {

    private final String name;
    Role role;
    int mainOrganizerEventsCount;//delete
    public Employee(String name, Role role, int mainOrganizerEventsCount) {
        this.name = name;
        this.role = role;
        this.mainOrganizerEventsCount = mainOrganizerEventsCount;
    }
    public Employee(String name, Role role) {
        this.name = name;
        this.role = role;
        this.mainOrganizerEventsCount = 0;
    }
    public Role getRole() {
        return role;
    }

    public int getMainOrganizerEventsCount() {
        return mainOrganizerEventsCount;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setMainOrganizerEventsCount(int mainOrganizerEventsCount) {
        this.mainOrganizerEventsCount = mainOrganizerEventsCount;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", role=" + role +
                ", mainOrganizerEventsCount=" + mainOrganizerEventsCount +
                '}';
    }
}

/**
 * Item     Price   Count       Sum
 * phone    100       5         500
 *
 *
 */
