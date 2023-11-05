package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CocktailParty extends Event {
    private Set<Cocktail> cocktails;
    private Set<Visitor> visitors;

    public CocktailParty() {
        super(EventType.COCKTAIL_PARTY);
        cocktails = EnumSet.noneOf(Cocktail.class);
        this.visitors = new HashSet<>();
    }

    public Set<Cocktail> getCocktails() {
        return cocktails;
    }

    @Override
    public boolean canEventStart() {
        long helper = getEmployees().stream()
                .filter(employee -> employee.role() == EmployeeRole.HELPER)
                .count();
        long organizer = getEmployees().stream()
                .filter(employee -> employee.role() == EmployeeRole.ORGANIZER)
                .count();
        return helper >= 10 && organizer >= 3 && getCocktails().size() >= visitors.size();
    }
}
