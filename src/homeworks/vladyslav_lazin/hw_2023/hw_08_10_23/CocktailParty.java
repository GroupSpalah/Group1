package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;

import java.util.List;
import java.util.Set;

public final class CocktailParty extends Event{
    private Set<String> availableCoctails;

    public CocktailParty(Set<String> availableCoctails) {
        this.availableCoctails = availableCoctails;
    }

}
