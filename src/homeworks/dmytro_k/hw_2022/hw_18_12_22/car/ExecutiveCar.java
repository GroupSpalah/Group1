package homeworks.dmytro_k.hw_2022.hw_18_12_22.car;

/*Создать также класс наследник Представительский автомобиль, в
котором переопределить методы: метод «Стоимость» возвращает число,
равное. Максимальная скорость * 250, а метод «Обновление модели»
увеличивает скорость на 5 км/ч.*/

public class ExecutiveCar extends Car {

    public ExecutiveCar(String name, int maxSpeed) {
        super(name, maxSpeed);
    }

   /* @Override
    public int getMaxSpeed() { //???
        return super.getMaxSpeed();
    }*/

   /* @Override
    public void setMaxSpeed(int maxSpeed) { //???
        super.setMaxSpeed(maxSpeed);
    }*/

    @Override
    public double price() {

        return super.getMaxSpeed() * 250;
    }

    @Override
    public void modelUpdate() {

        super.setMaxSpeed(super.getMaxSpeed() + 5);
    }
}
