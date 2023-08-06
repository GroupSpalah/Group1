package lessons.learn_class.learn_string;

/**
 Преобразовать данный текст, заменив каждую строку вида переменная=переменная+1; на строку вида переменная++;
 а каждую строку вида
 переменная=переменная–1;на строку вида переменная–– .
 */
public class Task3 {
    public static void main(String[] args) {
        String email = "Hello count=count+1; world value=value-1; friend";//

        String result = email
                .replaceFirst("count=count\\+1", "count++")
                .replaceFirst("value=value-1", "count--");

        System.out.println(result);

    }

}
