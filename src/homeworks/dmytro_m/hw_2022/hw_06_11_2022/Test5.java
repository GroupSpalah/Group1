package homeworks.dmytro_m.hw_2022.hw_06_11_2022;

public class Test5 {

    public static void main(String[] args) {
        int num = countsNumberDotsCommas(",.,.");
        System.out.println(num);
    }

    public static int countsNumberDotsCommas(String str) {

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String str2 = String.valueOf(c);
            if(str2.contains(",") || str2.contains(".")) {
                count++;
            }
        }
        return count;
    }

}
//        *** В заданной строке посчитать количество точек и запятых., charAt