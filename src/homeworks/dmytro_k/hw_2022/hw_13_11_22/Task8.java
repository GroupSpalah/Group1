package homeworks.dmytro_k.hw_2022.hw_13_11_22;

/*//See solutions
8) public static void main(String[] args) {
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
       }*/


public class Task8 {


    public static void main(String[] args) {

        String myStr = "Cartoon value=value+1;Tomcat count=count+1;Address variable=variable+1;";
        String myStrWithOutSpase = myStr.replace(" ", "");
        System.out.println(myStrWithOutSpase);
        StringBuilder builder = new StringBuilder();

        while (myStrWithOutSpase.length() != 0) {

            int indexBegin = myStr.indexOf("=");
            int indexEnd = myStr.indexOf("+");
            //int indexEnd2 = myStr.indexOf("-");

            String variableName = myStrWithOutSpase.substring(indexBegin, indexEnd - 1 /*| indexEnd2 - 1*/);

            String result = variableName.concat("=").concat(variableName).concat("\\+1;");

            String temp = myStr.replaceAll(result, variableName.concat("\\++;"));

            int dotIndex = temp.indexOf(";");

            String s = temp.substring(0, dotIndex + 1);

            builder.append(s);

            myStrWithOutSpase = myStrWithOutSpase.substring(indexBegin);

        }

        System.out.println(builder);

/*
        while (myStr.length() != 0) {
            int plusIndex = myStr.indexOf("+");
            int equalIndex = myStr.indexOf("=");

            String varName = myStr.substring(equalIndex + 1, plusIndex);

            String result = varName.concat("=").concat(varName).concat("\\+1;");

            String temp = myStr.replaceAll(result, varName.concat("\\++;"));

            int dotIndex = temp.indexOf(";");

            String s = temp.substring(0, dotIndex + 1);

            builder.append(s);

            myStr = myStr.substring(plusIndex + 3);

        }

        System.out.println(builder);
*/

    }
}
