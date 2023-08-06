package lessons.learn_class.learn_string;

/**
 *  Assume that email address is constructed by person's first name and followed by an underscore and last name.
 *
 *     Write a program that can swap first name with last name in the email (Saperated by an underscore).
 *     If the email doesn't contain an underscore print the given input email.
 *
 *         Ex:
 *             input: mike_tyson@gmail.com
 *             output: tyson_mike@gmail.com
 */
public class Task2 {
    public static void main(String[] args) {
        String email = "mike_tyson@gmail.com";

        String[] words = email.split("@");//"mike_tyson", "gmail.com"
        String[] words1 = words[0].split("_");//"mike", "tyson"

        String result = words1[1]
                .concat("_")//"mike_"
                .concat(words1[0])//"mike_tyson"
                .concat("@")
                .concat(words[1]);

        System.out.println(result);
    }

}
