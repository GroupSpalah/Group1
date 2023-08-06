package homeworks.dmytro_m.hw_2022.hw_18_12_2022.Car;

public class ExecutiveCar extends Car {

    public ExecutiveCar() {
    }

    public ExecutiveCar(String nameCar, int maxSpeed) {
        super(nameCar, maxSpeed);
    }

    @Override
    public int carCost() {
        return getMaxSpeed() * 250;
    }

    @Override
    public void setModelUpdate() {
        super.setModelUpdate();
        setMaxSpeed(getMaxSpeed() + 5);
    }

}
//        Создать также класс наследник Представительский автомобиль, в
//        котором переопределить методы: метод «Стоимость» возвращает число,
//        равное. Максимальная скорость * 250, а метод «Обновление модели»
//        увеличивает скорость на 5 км/ч.