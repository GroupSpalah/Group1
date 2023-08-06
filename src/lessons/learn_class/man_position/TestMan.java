package lessons.learn_class.man_position;

public class TestMan {
    public static void main(String[] args) {
        Position it = new Position("IT");
        Position manager = new Position("Manager");

        Man john = new Man("John", "Travolta", 32, Gender.MALE, it);
        Man jack = new Man("Jack", "Travolta", 38, Gender.MALE, manager);

        ManService manService = new ManService();

        boolean isEqualNames = manService.compareLastNames(john, jack);

        boolean isEqualPositions = manService.comparePositions(john, jack);
    }
}
