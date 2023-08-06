package lessons.regex;

import java.util.regex.Pattern;

public class LearnRegex {
    public static void main(String[] args) {
//        <h1>Hello</h1>
        /*String text = "Hello";
        String template = "H.llo";//any symbol*/
        /*
        String text = "Hello";
        String template = "H[ae]llo";//or a or e symbols*/
        /*
        String text = "Hello";
        String template = "H[a-eA-E]llo";//or a or e(from A to E) symbols*/
/*
        String text = "Hello";
        String template = "H[a-w&&[^bd]]llo";//from a to w, exclude b and d symbols symbols*/
/*
        String text = "Hello";
        String template = "H[0-9]llo";//from 0 to 9*/
/*
        String text = "Hello";
        String template = "H\\dllo";//from 0 to 9*/
//Quantors
        /*String text = "Haallo";
        String template = "H[a-r]{2}llo";//from a to r, only 2 times*/
        /*
        String text = "Haallo";
        String template = "H[a-r]{2,4}llo";//from a to r, from 2 to 4 times*/

        /*String text = "Haallo";
        String template = "H[a-r]*llo";//from a to r, from 0 to infinity times*/
        /*
        String text = "Haallo";
        String template = "H[a-r]+llo";//from a to r, from 1 to infinity times*/
/*
        String text = "Haallo";
        String template = "H[a-r]?llo";//from a to r, or 0 or 1 times*/

        String text = "Hearunrtllo";
        String template = "H.*(run|gun).*llo";//OR operator
        System.out.println(Pattern.matches(template, text));

    }
}
