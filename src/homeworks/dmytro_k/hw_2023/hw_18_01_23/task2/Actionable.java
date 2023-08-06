package homeworks.dmytro_k.hw_2023.hw_18_01_23.task2;

public interface Actionable {

    default void accelerate() {
        System.out.println("accelerate");
    }

    default void brake() {
        System.out.println("brake");
    }
}
