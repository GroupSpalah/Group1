package homeworks.dmytro_k.hw_2022.hw_18_12_22.airplane;

/*Создать также класс наследник Бомбардировщик, в котором переопределить метод «Стоимость»,
который вернет удвоенную стоимость относительно формулы для класса Самолет.*/

public class Bomber extends Airplane {

    public Bomber(String brand, String model, int maxSpeed, int maxHeight) {
        super(brand, model, maxSpeed, maxHeight);
    }

    @Override
    public double price() {

        return super.price() * 2;
    }
}
