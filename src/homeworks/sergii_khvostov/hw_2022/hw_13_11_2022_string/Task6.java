package homeworks.sergii_khvostov.hw_2022.hw_13_11_2022_string;

//@Khvostov

/*Assume that email address is constructed by person's first name
  and followed by an underscore and last name.
  Write a program that will print out information about user based on email.
  Print first name, last name, and domain.
  First and Last name should be printed with proper format -
  uppercase first letter and remaining lowercase.

              Ex:
                  input:
                      craig_federighi@apple.com

               Output:
                   First name: Craig
                   Last name: Federighi
                   Domain: apple
*/

public class Task6 {
    public static void main(String[] args) {
        String email = "craig_federighi@apple.com";

        String[] nameDomain = email.split("@");

        String[] nameSurname = nameDomain[0].split("_");

        String name = nameSurname[0];
        name = name.substring(0, 1).toUpperCase() +
                name.substring(1);

        String surName = nameSurname[1];
        surName = surName.substring(0, 1).toUpperCase() +
                surName.substring(1);

        String[] domainExt = nameDomain[1].split("\\.");

        String domain = domainExt[0];

        System.out.println("First name: ".concat(name) + "\n" +
                "Last name: ".concat(surName) + "\n" +
                "Domain: ".concat(domain));
    }
}
