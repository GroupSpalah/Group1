package homeworks.sergii_khvostov.hw_2022.hw_18_12_22.car;

/*Создать класс Автомобиль со свойствами: Название, Максимальная
скорость (в км/ч). Определить 2 виртуальных метода:
метод «Стоимость» –стоимость автомобиля, рассчитываемую по формуле:
Максимальная скорость * 100 и метод «Обновление модели», увеличивающий
максимальную скорость на 10.
Определить также метод «Информация»,
который возвращает строку, содержащую информацию об объекте:
Название, Максимальную скорость и Стоимость.
Создать также класс наследник Представительский автомобиль, в
котором переопределить методы: метод «Стоимость» возвращает число,
равное: Максимальная скорость * 250, а метод «Обновление модели»
увеличивает скорость на 5 км/ч.
В главной программе (либо по нажатию на кнопку) создать объект
класса Автомобиль с максимальной скоростью 140 км/ч и
класса Представительский автомобиль с максимальной скоростью 160 км/ч.
Вывести на экран (или форму) информацию об автомобилях. Обновить
модели автомобилей и снова вывести информацию о них.
*/

public class Car {

    private String title;
    private int maxSpeed;

    public Car(String title, int maxSpeed) {
        this.title = title;
        this.maxSpeed = maxSpeed;
    }

    public String getTitle() {
        return title;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int price() {
        return getMaxSpeed() * 100;
    }

    public void updateModel() {
        setMaxSpeed(getMaxSpeed() + 10);
    }

    public String info() {
        return "Title: " + getTitle() + "\n" +
                "Max speed: " + getMaxSpeed() +
                "\n" + "Price: " + price();
    }
}
