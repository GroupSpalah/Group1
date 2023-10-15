package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;

import java.util.List;

public final class CocktailParty extends Event{
    private int availableCoctails;

    public CocktailParty(List<Employee> eventStaff, int availableCoctails) {
        super(eventStaff);
        this.availableCoctails = availableCoctails;
    }

    public int getAvailableCoctails() {
        return availableCoctails;
    }

    public void setAvailableCoctails(int availableCoctails) {
        this.availableCoctails = availableCoctails;
    }
}
