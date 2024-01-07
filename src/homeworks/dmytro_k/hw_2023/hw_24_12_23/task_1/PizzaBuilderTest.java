package homeworks.dmytro_k.hw_2023.hw_24_12_23.task_1;

public class PizzaBuilderTest {
    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder()
                .addCheese("cheese")
                .addMeat("meat")
                .addMushroom("mushroom")
                .addVegetable("vegetable")
                .build();

        System.out.println(pizza);

        Pizza pizza2 = new PizzaBuilder()
                .addCheese("cheese")
                .addSeafood("seafood")
                .addVegetable("vegetable")
                .build();

        System.out.println(pizza2);
    }
}
