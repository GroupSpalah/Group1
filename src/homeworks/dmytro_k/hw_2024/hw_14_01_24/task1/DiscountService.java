package homeworks.dmytro_k.hw_2024.hw_14_01_24.task1;

/**1) Imagine you have сhain of stores. You need to implement discount system for people
 in some special events of a year like New Year.

 In this task we'll need help of Strategy pattern.
 First of all, you need to create `DiscountService` interface
 with method `getDiscount()` with return type `double`.

 You must create its implementations (with the same names) with such discounts:

 | Implementation name |Discount |
 | :---: | :---: |
 | DefaultDiscountService| 0 |
 | NewYearDiscountService| 20 |
 | BirthdayDiscountService| 33 |
 | BlackFridayDiscountService| 45 |

 Each of this implementation in result of execution of method
 `getDiscount()` must return discount according to table above.

 The last step will be creation of class called `DiscountStrategy`. It must have
 method `getDiscountServiceBySpecialEvent(String specialEvent)` with return type `DiscountService`
 where `specialEvent` can have such values: `"Birthday"`, `"Black Friday"`, `"New Year"`.

 Using `specialEvent`, you must write code that defines `DiscountService` implementation.

 In case if passed `specialEvent` doesn't have specific implementation
 you must return `DefaultDiscountService` by default.

 #### [Try to avoid these common mistakes, while solving task](https://mate-academy.github.io/jv-program-common-mistakes/java-core/patterns/strategy)


 */

public interface DiscountService {

    double getDiscount();
}
