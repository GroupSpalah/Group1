package homeworks.dmytro_k.hw_2023.hw_08_10_23.task2;

/**
 * На коктейльных вечеринках гости могут заказать коктейли из ограниченного количества.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CocktailParty extends Event {

    private Map<Visitor, Set<Cocktail>> visitorCocktails;//мапа, где ключ - юзер, значение - сет коктейлей++

    public CocktailParty() {
        super(EventType.COCKTAIL_PARTIES);
        this.visitorCocktails = new HashMap<>();
    }

    public void addCocktails(Visitor visitor, Cocktail cocktail) {
        if (visitorCocktails.containsKey(visitor)) {
            visitorCocktails
                    .get(visitor)
                    .add(cocktail);
        } else {
            Set<Cocktail> cocktails = visitor.getCocktails();
            cocktails.add(cocktail);
            visitorCocktails.put(visitor, cocktails);
        }
    }
}
