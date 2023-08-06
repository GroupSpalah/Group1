package homeworks.dmytro_k.hw_2022.hw_18_12_22.airplane;

/*Также создать класс Истребитель – наследник класса Самолет, для которого переопределить
метод «Стоимость» как утроенную стоимость, относительно формулы
стоимости для Самолета.*/

public class Fighter extends Airplane {

    public Fighter(String brand, String model, int maxSpeed, int maxHeight) {
        super(brand, model, maxSpeed, maxHeight);
    }

    @Override
    public double price() {

        return super.price() * 3;
    }
}
