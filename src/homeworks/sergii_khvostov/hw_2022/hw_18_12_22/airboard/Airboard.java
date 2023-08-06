package homeworks.sergii_khvostov.hw_2022.hw_18_12_22.airboard;

/*Создать класс Самолет со свойствами: Марка, Модель, Максимальная
скорость (в км/ч), Максимальная высота (в метрах).
Определить виртуальный метод «Стоимость» –
стоимость самолета,рассчитываемую по
формуле Максимальная скорость * 1000 + Максимальная высота * 100
Определить также метод «Информация», который возвращает строку,
содержащую информацию об объекте: Марка, Модель, Максимальную
скорость, Максимальную высоту и Стоимость.
Создать также класс наследник Бомбардировщик,
в котором переопределить метод «Стоимость»,
который вернет удвоенную стоимость
относительно формулы для класса Самолет.
Также создать класс Истребитель – наследник класса Самолет,
для которого переопределить метод «Стоимость» как утроенную стоимость,
относительно формулы стоимости для Самолета.
В главной программе (либо по нажатию на кнопку) создать объект
класса Самолет, класса Бомбардировщик, класса Истребитель.
Вывести на экран (или форму) информацию о самолетах*/

public class Airboard {
    private String brand;
    private String model;
    private int maxSpeed;
    private int maxHeight;

    public Airboard(String brand, String model, int maxSpeed, int maxHeight) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxHeight = maxHeight;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int price() {
        return getMaxSpeed() * 1000 + getMaxHeight() * 100;
    }

    public String info() {
        return "Brend: " + getBrand() + "\n" + "Model: " + getModel() + "\n" +
                "Max speed: " + getMaxSpeed() + "\n" + "Max height: "
                + getMaxHeight() + "\n" + "Price: " + price();
    }
}