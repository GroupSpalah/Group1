package homeworks.dmytro_m.hw_2023.hw_19_03_23.task;

public interface Ballable{

   int count = 0; // нельзя делать поле абстрактным и приватным в интерфейсе

//    public void jump(){}    // Абстрактные методы интерфейса не могут иметь тело

    default String getName(){

        return "John";
    }

}