package lessons.patterns.creational;
/*
 * ПОРОЖДАЮЩИЙ ШАБЛОН ПРОЕКТИРОВАНИЯ,
 * предоставляющий подклассам интерфейс для создания экземпляров некоторого класса.
 * В момент создания наследники могут определить, какой класс создавать.
 * Назначение: определяет стандартный метод создания объекта, не связанный с вызовом конструктора,
 * оставляя решение о том, какой именно объект создавать, за подклассами.
 * Иными словами, Фабрика делегирует создание объектов наследникам родительского класса.
 * Это позволяет использовать в коде программы не специфические классы,
 * а манипулировать абстрактными объектами на более высоком уровне.
 * */
public class FabricMethod {
    public static void main(String[] args) {
        CarFabric carFabric = new CarFabric();

        SomeCar bmw = carFabric.getCar("Mercedes");

        System.out.println(bmw.getModel());
    }
}

interface SomeCar {
    String getModel();
}

interface CarCreator {
    SomeCar getCar(String model);
}

class CarFabric implements CarCreator {
    @Override
    public SomeCar getCar(String model) {
        return switch (model) {
            case "Bmw" -> new Bmw("X5");
            case "Mercedes" -> new Mercedes("G8");
            default -> new Mercedes("Sprinter");
        };
    }
}

class Bmw implements SomeCar {
    private String model;

    public Bmw(String name) {
        this.model = name;
    }

    @Override
    public String getModel() {
        return "Bmw";
    }
}

class Mercedes implements SomeCar {
    private String name;

    public Mercedes(String name) {
        this.name = name;
    }

    @Override
    public String getModel() {
        return "Mercedes";
    }
}
