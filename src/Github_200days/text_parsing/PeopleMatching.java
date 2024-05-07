package Github_200days.text_parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeopleMatching {
    public static void main(String[] args) {
        String people = """
            Flinstone, Fred, 1/1/1900
            Rubble, Barney, 2/2/1905
            Flinstone, Wilma, 3/3/1910
            Rubble, Betty, 4/4/1915
            """;
        String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4})\\n";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(people);

        while(mat.find()) {
            System.out.printf("%s,%s %s%n",mat.group("firstName"),mat.group("lastName"),mat.group("dob"),mat.end("firstName"));
        }
    }
}
