package lessons.multithreading;

public class Example5 {
    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();
        myThread5.setName("myThread5");
        myThread5.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Name MyThread5 is " + myThread5.getName() + "  Priority of MyThread5 =" + myThread5.getPriority());

        MyThread5 myThread6 = new MyThread5();
        System.out.println("Name MyThread6 is " + myThread6.getName() + "  Priority of MyThread5 =" + myThread6.getPriority());
    }

}

class MyThread5 extends Thread {
    public void run() {
        System.out.println("Hello");
    }
}