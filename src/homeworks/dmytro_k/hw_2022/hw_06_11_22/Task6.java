package homeworks.dmytro_k.hw_2022.hw_06_11_22;

/**** В заданной строке посчитать количество точек и запятых., charAt*/

public class Task6 {

    public static void main(String[] args) {

        String myStr1 = "q,w.mer.ty.ui,o,.p.";
        int count = 0;

        for (int i = 0; i < myStr1.length(); i++) {
            char symbol = myStr1.charAt(i);
            if (symbol == ',' || symbol == '.') {
                count++;
            }
        }

        System.out.println(count);
    }
}
