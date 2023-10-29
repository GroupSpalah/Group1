package homeworks.dmytro_k.hw_2023.hw_08_10_23.task2;

import java.util.HashSet;
import java.util.Set;

public class Visitor {

    private String name;

    private Set<Cocktail> cocktails;

    public Visitor(String name) {
        this.name = name;
        cocktails = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addCocktails(Cocktail cocktail) {
        cocktails.add(cocktail);
    }

    public Set<Cocktail> getCocktails() {
        return cocktails;
    }
}
