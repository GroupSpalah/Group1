package homeworks.dmytro_k.hw_2022.hw_13_11_22;

/*6) Assume that email address is constructed by person's first name and followed
by an underscore and last name.

      Write a program that will print out information about user based on email.
      Print first name, last name, and domain.

      First and Last name should be printed with proper format - uppercase first
      letter and remaining lowercase.

              Ex:
                  input:
                      craig_federighi@apple.com

               Output:
                   First name: Craig
                   Last name: Federighi
                   Domain: apple*/

public class Task6 {

    public static void main(String[] args) {

        String emailAddress = "craig_federighi@apple.com";

        String[] nameAndDomain = emailAddress.split("@");

        String[] fullName = nameAndDomain[0].split("_");

        String[] domain = nameAndDomain[1].split("\\.");

        String firstName = fullName[0].substring(0, 1).toUpperCase() + fullName[0].substring(1);

        String lastName = fullName[1].substring(0, 1).toUpperCase() + fullName[1].substring(1);

        System.out.println("First name: " + firstName);

        System.out.println("Last name: " + lastName);

        System.out.println("Domain: " + domain[0]);
    }
}
