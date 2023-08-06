package lessons.inner_class;

public class AnonymousClass {
    public static void main(String[] args) {
        Printable printable = new Printable() {

            @Override
            public void print() {

            }
        };
    }
}

interface Printable {
    void print();
}
