package homeworks.sergii_khvostov.hw_2022.hw_13_11_2022_string;

//@Khvostov

/*Write a function to convert a name into initials.
   	This kata strictly takes two words with one space in between them.
   	The output should be two capital letters with a dot separating them.
   	It should look like this:
   	Sam Harris => S.H
   	patrick feeney => P.F*/

public class Task1 {
    public static void main(String[] args) {
        String human1 = "Sam Harris";
        String human2 = "patrick feeney";

        String[] arr1 = human1.split(" ");
        String[] arr2 = human2.split(" ");

        String human1Word1 = String.valueOf(arr1[0].charAt(0));
        String human1Word2 = String.valueOf(arr1[1].charAt(0));
        String resultHuman1 = human1Word1.concat(".").concat(human1Word2);

        String human2Word1 = String.valueOf(arr2[0].charAt(0));
        String human2Word2 = String.valueOf(arr2[1].charAt(0));
        String resultHuman2 = human2Word1.concat(".").concat(human2Word2);

        System.out.println(resultHuman1.toUpperCase() + "\n" +
                resultHuman2.toUpperCase());
    }
}
