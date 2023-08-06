package homeworks.sergii_khvostov.hw_2022.hw_04_09_22_conditional_statements;

//@Khvostov

/* 1) Написать логическое выражение для выбора коэффициента учета
стажа работы по специальности в конкурсе на бюджетные места.Если
стаж до 2 лет, то коэффициент равен 11, если стаж от 2 до 5 лет –12,
если больше 5 лет –13.*/

 public class If_Else {
    public static void main(String[] args) {
        int workExp = 0;
        int coef = 0;

        if (workExp > 0 && workExp < 2) {
            coef = 11;
        } else if (workExp >= 2 && workExp < 5) {
            coef = 12;
        } else if (workExp >= 5) {
            coef = 13;
        }
        System.out.println(coef);
    }
}


