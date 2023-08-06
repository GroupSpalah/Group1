package homeworks.dmytro_m.hw_2022.hw_18_12_2022.Car;

public class Car {
    private String nameCar;
    private int maxSpeed;

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Car() {

    }

    public Car(String nameCar, int maxSpeed) {
        this.nameCar = nameCar;
        this.maxSpeed = maxSpeed;
    }

    public int carCost() {
        return maxSpeed * 100;
    }

    public void setModelUpdate() {
        setMaxSpeed(maxSpeed + 10);
    }

    public void information() {
        System.out.println("Name car " + nameCar + ". Max speed " + maxSpeed + ". Car cost " + carCost() + ".");
    }

}
//        1) Создать класс Автомобиль со свойствами: Название, Максимальная
//        скорость (в км/ч). Определить 2 виртуальных метода: метод «Стоимость» –стоимость автомобиля,
//        рассчитываемую по формуле. Максимальная скорость * 100 и метод «Обновление модели», увеличивающий
//        максимальную скорость на 10. Определить также метод «Информация»,
//        который возвращает строку, содержащую информацию об объекте:
//        Название, Максимальную скорость и Стоимость.
//        Создать также класс наследник Представительский автомобиль, в
//        котором переопределить методы: метод «Стоимость» возвращает число,
//        равное. Максимальная скорость * 250, а метод «Обновление модели»
//        увеличивает скорость на 5 км/ч.
//        В главной программе (либо по нажатию на кнопку) создать объект
//        класса Автомобиль с максимальной скоростью 140 км/ч и класса
//        Представительский автомобиль с максимальной скоростью 160 км/ч.
//        Вывести на экран (или форму) информацию об автомобилях. Обновить
//        модели автомобилей и снова вывести информацию о них.