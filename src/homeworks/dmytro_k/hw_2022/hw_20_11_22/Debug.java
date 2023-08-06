package homeworks.dmytro_k.hw_2022.hw_20_11_22;

public class Debug {

    public static void main(String[] args) {
        String myStr1 = "Cartoon value=value+1;Tomcat count=count+1;Address variable=variable+1;";

        StringBuilder builder = new StringBuilder();

        while (myStr1.length() != 0) {
            int plusIndex = myStr1.indexOf("+");
            int equalIndex = myStr1.indexOf("=");

            String varName = myStr1.substring(equalIndex + 1, plusIndex);

            String result = varName.concat("=").concat(varName).concat("\\+1;");

            String temp = myStr1.replaceAll(result, varName.concat("\\++;"));

            int dotIndex = temp.indexOf(";");

            String s = temp.substring(0, dotIndex + 1);

            builder.append(s);

            myStr1 = myStr1.substring(plusIndex + 3);

        }

        System.out.println(builder);
    }
}
