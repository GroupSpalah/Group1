package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;

import java.util.Set;

public final class CocktailParty extends Event {
    private Set<Cocktail> availableCoctails;

    public CocktailParty(Set<Cocktail> availableCoctails) {
        this.availableCoctails = availableCoctails;
    }

}
