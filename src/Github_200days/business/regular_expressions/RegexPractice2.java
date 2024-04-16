package Github_200days.business.regular_expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice2 {
    public static void main(String[] args) {
        String regex = "(?:((\\d{1,2})[-,.\s]?)?(?:(\\d{3})[-,.\s]?)(?:\\d{3})[-,.\\s]?)(\\d{4})";
        String phoneNumber = "12.232.333.2365";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(phoneNumber);

        if (mat.matches()){
            System.out.format("Country code: %s\n",mat.group(1));
            System.out.format("Area code: %s\n",mat.group(2));
            System.out.format("Exchange: %s\n",mat.group(3));
            System.out.format("Line number: %s\n",mat.group(4));
        }
    }
}
