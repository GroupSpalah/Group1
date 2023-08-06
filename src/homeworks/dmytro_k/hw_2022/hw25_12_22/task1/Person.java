package homeworks.dmytro_k.hw_2022.hw25_12_22.task1;

/*1) Создайте класс Person с полями firstName (String), lastName (String), age (int),
gender (String), phoneNumber (int), и пять перегруженных методов.
Создайте класс, который будет использовать экземпляр класса Person и его методы.*/

public class Person {

   private String firstName;
   private String lastName;
   private String gender;
   private int age;
   private int phoneNumber;

   public Person(String firstName, String lastName, String gender, int age, int phoneNumber) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.gender = gender;
      this.age = age;
      this.phoneNumber = phoneNumber;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getGender() {
      return gender;
   }

   public int getAge() {
      return age;
   }

   public int getPhoneNumber() {
      return phoneNumber;
   }

   protected void printInfo(String firstName){
      System.out.println("first name: " + firstName);
   }

   protected void printInfo(String firstName, String lastName){
      System.out.println("\nfirst name: " + firstName + " last name: " + lastName);
   }

   protected void printInfo(String firstName, String lastName, String gender){
      System.out.println("\nfirst name: " + firstName + " last name: " + lastName +
              " gender: " + gender);
   }

   protected void printInfo(String firstName, String lastName, String gender, int age){
      System.out.println("\nfirst name: " + firstName + " last name: " + lastName + " gender: "
              + gender + " age:" + age);
   }

   protected void printInfo(String firstName, String lastName, String gender, int age, int phoneNumber){
      System.out.println("\nfirst name: " + firstName + " last name: " + lastName + " gender: " +
              gender + " age: " + age + " phone number: " + phoneNumber);
   }
}
