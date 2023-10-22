package homeworks.dmytro_k.hw_2023.hw_08_10_23.task2;

/**
 * На коктейльных вечеринках гости могут заказать коктейли из ограниченного количества.
 */

import java.util.LinkedHashSet;
import java.util.Set;

public class CocktailParties extends Event {

    private Set<Integer> cocktails;

    public CocktailParties() {
        super(EventType.COCKTAIL_PARTIES);
        this.cocktails = new LinkedHashSet<>();
    }
}
