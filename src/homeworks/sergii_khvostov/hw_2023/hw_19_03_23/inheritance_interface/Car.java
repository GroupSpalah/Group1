package homeworks.sergii_khvostov.hw_2023.hw_19_03_23.inheritance_interface;

/*public class Car extends TrafficLight {

    private int countOfSpeeds;
    private int countOfDoors;
    private String model;

    protected Car(int countOfSpeeds, double countOfDoors, String model) {

        *//*В конструкторе класса Car параметры имеют те же имена,
        что и поля класса, поэтому операторы присваивания
        внутри конструктора не будут работать правильно.
        Параметр countOfDoors имеет тип double, но должен быть целочисленным.
        В конструкторе класса Car не вызывается конструктор суперкласса,
        поэтому это также является ошибкой.
        Нет this.*//*

        countOfSpeeds = countOfSpeeds;
        countOfDoors = countOfDoors;
        model = model;
    }

    public void drive() {
        System.out.println("Go...");
    }

}*/
