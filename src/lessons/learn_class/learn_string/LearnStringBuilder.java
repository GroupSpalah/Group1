package lessons.learn_class.learn_string;

public class LearnStringBuilder {
    public static void main(String[] args) {
        String str = "Hello";

        StringBuilder builder = new StringBuilder(str);

        for (int i = 0; i < 5; i++) {
//            str += i;
            builder.append(i);
        }

        System.out.println(builder.toString());
    }
}

/*
* iter0: i == 0; str = "Hello0", "Hello"
* iter1: i == 1; str = "Hello01", "Hello0"
* iter2: i == 2; str = "Hello012", "Hello01"
* */
