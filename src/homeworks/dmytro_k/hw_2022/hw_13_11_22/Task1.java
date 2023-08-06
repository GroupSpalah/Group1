package homeworks.dmytro_k.hw_2022.hw_13_11_22;

/*1) Write a function to convert a name into initials.
   	This kata strictly takes two words with one space in between them.
   	The output should be two capital letters with a dot separating them.
   	It should look like this:
    Sam Harris => S.H
   	patrick feeney => P.F*/

public class Task1 {

    public static void main(String[] args) {

        String otherName = "Sam Harris";

        makeInitials(otherName);

        System.out.println();

        makeInitials("patrick feeney");
    }

    public static void makeInitials(String name) {

        String[] words = name.split(" ");

        int count = 0;

        for (String word : words) {
            System.out.print(word.toUpperCase().charAt(0));
            count++;
            if (count == 1) {
                System.out.print(".");
            }
        }
    }
}
