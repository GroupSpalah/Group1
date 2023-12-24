package lessons.patterns.creational.builder;

public class Car {
    private int age;
    private String model;
    private int countWheels;

    public void setAge(int age) {
        this.age = age;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCountWheels(int countWheels) {
        this.countWheels = countWheels;
    }
}

class CarBuilder {

    private Car car;

    public CarBuilder() {
        car = new Car();
    }

    public CarBuilder buildModel(String model) {
        car.setModel(model);
        return this;
    }

    public CarBuilder buildAge(int age) {
        car.setAge(age);
        return this;
    }

    public CarBuilder buildCountWheels(int wheels) {
        car.setCountWheels(wheels);
        return this;
    }

    public Car build() {
        return car;
    }
}

class TestBuilder {
    public static void main(String[] args) {
        Car bmw = new CarBuilder()
                .buildAge(32)
                .buildCountWheels(6)
                .buildModel("Bmw")
                .build();
    }
}
