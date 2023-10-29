package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;

import java.util.List;
import java.util.Set;

public class CocktailParty extends Event {
    static Set<Cocktail> cocktails;
    private long helperCount;
    private long organizerCount;

    public CocktailParty(EventType type, List<Employee> employees, Set<Cocktail> cocktails,
                         long helperCount, long organizerCount) {
        super(type, employees);
        CocktailParty.cocktails = cocktails;
        this.helperCount = helperCount;
        this.organizerCount = organizerCount;
        addEvent();
    }

    @Override
    public boolean canEventStart() {
        return helperCount >= 10 && organizerCount >= 3;
    }
}
