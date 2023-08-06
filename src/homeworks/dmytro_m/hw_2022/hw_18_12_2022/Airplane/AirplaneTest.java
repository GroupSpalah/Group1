package homeworks.dmytro_m.hw_2022.hw_18_12_2022.Airplane;

public class AirplaneTest {

    public static void main(String[] args) {

        Airplane airplane1 = new Airplane("Daewoo", "Lanos", 800, 50);
        System.out.println(airplane1);

        BomberAircraft bomberAircraft1 = new BomberAircraft("Hornet", "F/A-18", 4, 1915);

        FighterAircraft fighterAircraft1 = new FighterAircraft("McDonnell Douglas", "F15", 3100, 5);
        System.out.println(fighterAircraft1);

    }
}
//        3) Создать класс Самолет со свойствами: Марка, Модель, Максимальная
//        скорость (в км/ч), Максимальная высота (в метрах).
//        Определить виртуальный метод «Стоимость»
//        – стоимость самолета, рассчитываемую по
//        формуле Максимальная скорость * 1000 + Максимальная высота * 100


//        Определить также метод «Информация», который возвращает строку,
//        содержащую информацию об объекте: Марка, Модель, Максимальную
//        скорость, Максимальную высоту и Стоимость.

//        Создать также класс наследник Бомбардировщик, в котором переопределить метод «Стоимость»,
//        который вернет удвоенную стоимость
//        относительно формулы для класса Самолет. Также создать класс Истребитель – наследник класса Самолет,
//        для которого переопределить
//        метод «Стоимость» как утроенную стоимость, относительно формулы
//        стоимости для Самолета.
//        В главной программе (либо по нажатию на кнопку) создать объект
//        класса Самолет, класса Бомбардировщик, класса Истребитель. Вывести на экран (или форму) информацию
//        о самолетах