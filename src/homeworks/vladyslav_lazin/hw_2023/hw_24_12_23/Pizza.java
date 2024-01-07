package homeworks.vladyslav_lazin.hw_2023.hw_24_12_23;

public class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetables;
    private String mushrooms;

    private Pizza() {
    }
    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public void setSeafood(String seafood) {
        this.seafood = seafood;
    }

    public void setVegetables(String vegetables) {
        this.vegetables = vegetables;
    }

    public void setMushrooms(String mushrooms) {
        this.mushrooms = mushrooms;
    }

    public String getCheese() {
        return cheese;
    }

    public String getMeat() {
        return meat;
    }

    public String getSeafood() {
        return seafood;
    }

    public String getVegetables() {
        return vegetables;
    }

    public String getMushrooms() {
        return mushrooms;
    }

    public static class PizzaBuilder {
        private Pizza pizza;
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
        public PizzaBuilder addVegetables(String vegetables) {
            pizza.setVegetables(vegetables);
            return this;
        }
        public PizzaBuilder addMushrooms(String mushrooms) {
            pizza.setMushrooms(mushrooms);
            return this;
        }
        public Pizza build() {
            return pizza;
        }
    }
}
