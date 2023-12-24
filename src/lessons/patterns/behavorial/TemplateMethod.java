package lessons.patterns.behavorial;

/*
 ПОВЕДЕНЧЕСКИЙ ШАБЛОН ПРОЕКТИРОВАНИЯ, определяющий основу алгоритма и позволяющий
 наследникам переопределять некоторые шаги алгоритма, не изменяя его структуру в целом.
 http://www.journaldev.com/1763/template-method-design-pattern-in-java
 */

abstract class House {
    private void buildPillars() {
        System.out.println("Build pillars");
    }

    public abstract void installDoors();
    public abstract void installRoof();

    private void buildWindows() {
        System.out.println("Install windows");
    }

    public final void buildHouse() {
        buildPillars();
        installDoors();
        installRoof();
        buildWindows();
    }
}

class WoodHouse extends House {

    @Override
    public void installDoors() {
        System.out.println("Install wood doors");
    }

    @Override
    public void installRoof() {
        System.out.println("Install wood roof");
    }
}

class TestTM {
    public static void main(String[] args) {
        House woodHouse = new WoodHouse();

        woodHouse.buildHouse();
    }
}
