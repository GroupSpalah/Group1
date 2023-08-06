package homeworks.dmytro_m.hw_2022.hw_04_09_2022_conditional;

public class Task2 {
    public static void main(String[] args) {
        //        2) Дано число, нужно вывести в консоль оно больше/меньше/равно нулю.
        int num = 44;
        if(num > 0) {
            System.out.println("Above zero");
        } else if(num == 0) {
            System.out.println("equals zero");
        } else if(num < 0) {
            System.out.println("less than zero");
        }

    }
}
