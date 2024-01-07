package homeworks.dmytro_k.hw_2023.hw_24_12_23.task_1;

public class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public void setSeafood(String seafood) {
        this.seafood = seafood;
    }

    public void setVegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    public void setMushroom(String mushroom) {
        this.mushroom = mushroom;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "cheese='" + cheese + '\'' +
                ", meat='" + meat + '\'' +
                ", seafood='" + seafood + '\'' +
                ", vegetable='" + vegetable + '\'' +
                ", mushroom='" + mushroom + '\'' +
                '}';
    }
}
class PizzaBuilder {

    private final Pizza pizza;

    public PizzaBuilder() {
        pizza = new Pizza();
    }

    public PizzaBuilder addCheese(String cheese) {
        pizza.setCheese(cheese);
        return this;
    }

    public PizzaBuilder addMeat(String meat) {
        pizza.setMeat(meat);
        return this;
    }

    public PizzaBuilder addSeafood(String seafood) {
        pizza.setSeafood(seafood);
        return this;
    }

    public PizzaBuilder addVegetable(String vegetable) {
        pizza.setVegetable(vegetable);
        return this;
    }

    public PizzaBuilder addMushroom(String mushroom) {
        pizza.setMushroom(mushroom);
        return this;
    }

    public Pizza build() {
        return pizza;
    }
}