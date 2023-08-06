package homeworks.dmytro_m.hw_2023.hw_18_01.interfaces;

public interface Accelerate {
    default void drive() {
        System.out.println("Car rides");
    }
}
