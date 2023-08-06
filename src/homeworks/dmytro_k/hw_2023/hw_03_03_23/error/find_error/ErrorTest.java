package homeworks.dmytro_k.hw_2023.hw_03_03_23.error.find_error;

public class ErrorTest {
    public static void main(String[] args) {
        Run run = new Run();

        run.doIt();
        run.doStuff();

        Test test = new Test() { // экземпляр абстрактного класса?
            @Override
            public void doIt() {
                super.doIt();
            }
        };

        test.doIt();

        Compile compile = new Compile() { // экземпляр абстрактного класса?
            @Override
            public void doIt(int x) {
                super.doIt(x);
            }
        };

        compile.doIt(5);

        Task task = new Task();
        task.doIt();
    }
}
