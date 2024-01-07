package vladyslav_lazin.hw_2023.hw_24_12_23;
import homeworks.vladyslav_lazin.hw_2023.hw_24_12_23.Pizza;
import org.junit.Test;
import static org.junit.Assert.*;

public class PizzaBuilderTest {
    @Test
    public void builderShouldReturnPizza() {
        Pizza pizza = new Pizza.PizzaBuilder()
                .addMushrooms("champignons")
                .addCheese("gouda")
                .addMeat("pork")
                .build();
        assertEquals("champignons", pizza.getMushrooms());
        assertEquals("gouda", pizza.getCheese());
        assertEquals("pork", pizza.getMeat());
        assertNull(pizza.getSeafood());
        assertNull(pizza.getVegetables());
    }
}
