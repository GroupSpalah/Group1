package homeworks.dmytro_k.hw_2022.hw_18_12_22.car;

/*В главной программе (либо по нажатию на кнопку) создать объект
класса Автомобиль с максимальной скоростью 140 км/ч ++
и класса Представительский автомобиль с максимальной скоростью 160 км/ч.++
Вывести на экран (или форму) информацию об автомобилях. Обновить
модели автомобилей и снова вывести информацию о них.++*/

public class CarService {

    public static void main(String[] args) {

        Car car1 = new Car("ZAZ", 140);

        ExecutiveCar executiveCar1 = new ExecutiveCar("ZAZ", 160);

        System.out.println(car1.information());

        System.out.println(executiveCar1.information());

        car1.modelUpdate();
        System.out.println(car1.information());

        executiveCar1.modelUpdate();
        System.out.println(executiveCar1.information());
    }
}
