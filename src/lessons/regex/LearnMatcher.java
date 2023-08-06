package lessons.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearnMatcher {
    public static void main(String[] args) {
        String text = "Hearunrtllo";
        String template = "H.*(run|gun).*llo";

        Pattern pattern = Pattern.compile(template);

        Matcher matcher = pattern.matcher(text);

//        System.out.println(matcher.matches());

        String text1    =
                "This is the text which is to be searched " +
                        "for occurrences of the word 'is'.";

        String patternString = "is";

        Pattern pattern1 = Pattern.compile(patternString);
        Matcher matcher1 = pattern1.matcher(text);

        int count = 0;
        while(matcher1.find()) {
            count++;
            String group = matcher1.group();
            System.out.println("found: " + count + " : "
                    + matcher1.start() + " - " + matcher1.end());
        }
    }
}
