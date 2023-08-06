package lessons.interfaces;

/**
 * Сohesion and coupling:
 * 		### Когезия означает что класс или модуль может делать. Низкая когезия означает что класс делает много операций,
 * 		класс несфукосирован на том, что он должен делать.
 * 		Высокая когезия означает что класс сфокусирован на том, что он должен делать,
 * 		то есть только методы относящиеся к намерениям класса.
 * 		### Связанность - термин относящийся как зависят или относятся два класса или модуля.
 * 		Для низко связанных классов, изменения кода в одном классе не должно влиять на другой класс.
 * 		Высокое связывание приводит к тому, что сложно менять и поддерживать код, поскольку классы тесно связаны,
 * 		внесение изменений может потребовать полной модернизации системы
 *
 * 	Good software design has high cohesion and low coupling.
 */
public class LowCouplingCode {
    private One one;

    public LowCouplingCode(One one) {
        this.one = one;
    }

    public void action() {
        one.print();
    }
}

 class LowCouplingCodeNew {
    private Printable printable;

     public LowCouplingCodeNew(Printable printable) {
         this.printable = printable;
     }

     public void action() {
        printable.print();
    }
}

interface Printable {
    void print();
}

class One implements Printable {

    @Override
    public void print() {
        System.out.println("One");
    }
}

class Two implements Printable {

    @Override
    public void print() {
        System.out.println("Two");
    }
}

class TestLCC {
    public static void main(String[] args) {
        Printable one = new One();
        Printable two = new Two();

        new LowCouplingCodeNew(two);
    }
}
