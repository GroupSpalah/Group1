package homeworks.sergii_khvostov.hw_2023.hw_24_12_23;

/*Suppose we have the next class:
public class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;

    private Pizza() {}

    public static PizzaBuilder base() {
    return new PizzaBuilder();
    }
  }
Create public static inner class named PizzaBuilder inside Pizza class
 that correspond the next class diagram:
PizzaBuilder:
- pizza: Pizza
- PizzaBuilder()
+ addCheese(cheese:String):PizzaBuilder
+ addMeat(meat:String):PizzaBuilder
+ addSeafood(seafood:String):PizzaBuilder
+ addVegetable(vegetable:String):PizzaBuilder
+ addMushroom(mushroom:String):PizzaBuilder
+ build():Pizza
Inside the "cook" method create and return an instance of Pizza class
 with your at least three favorite ingredients.
*/
public class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;

    private Pizza() {}

    public static PizzaBuilder base() {
        return new PizzaBuilder();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("My Pizza Ingredients:\n");

        if (cheese != null) {
            result.append("Cheese: ").append(cheese).append("\n");
        }
        if (meat != null) {
            result.append("Meat: ").append(meat).append("\n");
        }
        if (seafood != null) {
            result.append("Seafood: ").append(seafood).append("\n");
        }
        if (vegetable != null) {
            result.append("Vegetable: ").append(vegetable).append("\n");
        }
        if (mushroom != null) {
            result.append("Mushroom: ").append(mushroom).append("\n");
        }

        return result.toString();
    }

    public static class PizzaBuilder {
        private Pizza pizza;

        public PizzaBuilder() {
            this.pizza = new Pizza();
        }

        public PizzaBuilder addCheese(String cheese) {
            pizza.cheese = cheese;
            return this;
        }

        public PizzaBuilder addMeat(String meat) {
            pizza.meat = meat;
            return this;
        }

        public PizzaBuilder addSeafood(String seafood) {
            pizza.seafood = seafood;
            return this;
        }

        public PizzaBuilder addVegetable(String vegetable) {
            pizza.vegetable = vegetable;
            return this;
        }

        public PizzaBuilder addMushroom(String mushroom) {
            pizza.mushroom = mushroom;
            return this;
        }

        public Pizza build() {
            return pizza;
        }
    }
    public static Pizza cook() {
        return base()
                .addCheese("Mozzarella")
                .addSeafood("Mussel")
                .addMushroom("Champignon")
                .build();
    }
}

class TestPizza {
    public static void main(String[] args) {
        Pizza myPizza = Pizza.cook();
        System.out.println(myPizza);
    }
}


