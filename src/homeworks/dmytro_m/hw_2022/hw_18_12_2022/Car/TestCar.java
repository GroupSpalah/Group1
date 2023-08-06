package homeworks.dmytro_m.hw_2022.hw_18_12_2022.Car;

public class TestCar {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 140);
        car.information();
        car.setModelUpdate();
        car.information();

        ExecutiveCar executiveCar = new ExecutiveCar("Bentley", 160);
        executiveCar.information();
        executiveCar.setModelUpdate();
        executiveCar.information();

    }
}
//        В главной программе (либо по нажатию на кнопку) создать объект
//        класса Автомобиль с максимальной скоростью 140 км/ч и класса
//        Представительский автомобиль с максимальной скоростью 160 км/ч.
//        Вывести на экран (или форму) информацию об автомобилях. Обновить
//        модели автомобилей и снова вывести информацию о них.