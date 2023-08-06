package homeworks.dmytro_k.hw_2022.hw_18_12_22.airplane;

/*В главной программе (либо по нажатию на кнопку) создать объект
класса Самолет, класса Бомбардировщик, класса Истребитель. Вывести
на экран (или форму) информацию о самолетах*/

public class AirplaneService {

    public static void main(String[] args) {

        Airplane airplane1 = new Airplane("Boeing", "747", 988, 12800);

        Bomber bomber1 = new Bomber("Northrop", "B-2 Spirit", 1010, 15240);

        Fighter fighter1 = new Fighter("Lockheed/Boeing", "F-22 Raptor", 2410, 20000);

        System.out.println(airplane1.information());

        System.out.println(bomber1.information());

        System.out.println(fighter1.information());
    }
}
