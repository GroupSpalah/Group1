package homeworks.dmytro_m.hw_2022.hw_13_11_2022;

public class Test6 {

    public static void main(String[] args) {
        String email = "craig_federighi@apple.com";
        userInformationFromEmail(email);
        String[] arr = email.split("\\.");

    }

    public static void userInformationFromEmail(String email) {

        String[] arr1 = email.split("_");//craig federighi@apple.com
        String[] arr2 = arr1[1].split("@");
        String[] arr3 = arr2[1].split("\\.");

        String name = arr1[0].substring(0, 1).toUpperCase() + arr1[0].substring(1);
        String surName = arr2[0].substring(0, 1).toUpperCase() + arr2[0].substring(1);
        String domain = arr3[0];

        System.out.println("Name " + name + ". Last Name " + surName + ". Surname " + domain + ".");
    }
}

//        6) Предположим, что адрес электронной почты состоит из имени человека,
//        за которым следует символ подчеркивания и фамилия.
//
//          Напишите программу, которая будет распечатывать информацию о пользователе на основе электронной почты.
//       Напечатайте имя, фамилию и домен.
//
//        Имя и фамилия должны быть напечатаны в правильном формате - первая буква в верхнем регистре,
//      а остальные строчные.
//
//        Ex:
//        input:
//        craig_federighi@apple.com
//
//               Output:
//                       First name: Craig
//                       Last name: Federighi
//                       Domain: apple