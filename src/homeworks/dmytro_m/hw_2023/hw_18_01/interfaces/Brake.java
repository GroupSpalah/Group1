package homeworks.dmytro_m.hw_2023.hw_18_01.interfaces;

public interface Brake {
    default void brake() {
        System.out.println("Car is stopped");
    }
}
