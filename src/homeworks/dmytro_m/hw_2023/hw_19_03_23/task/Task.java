package homeworks.dmytro_m.hw_2023.hw_19_03_23.task;

class Task implements Actionable {

    @Override
    public void doIt() {
    }
}

abstract class Test extends Task { //нет смысла указывать класс абстрактным, так как у него нет абстрактных методов
}

abstract class Compile extends Task {   // нет смысла указывать класс абстрактным, так как у него нет абстрактных методов
    public void doIt(int x) {  // метод не переопределяется а перегружается
    }
}

class Run extends Task implements Actionable {
    public void doStuff() { // нет смысла наследоваться и имплементиться от Task и Actionable
        //  так как единственный метод в Actionable уже реализован в Task
    }
}

interface Actionable {
    public void doIt();    //можно не указывать public

}

//    Какие будут ошибки?