package Github_200days.business.text_parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TranscriptParser {
    public static void main(String[] args) {
        String transcript = """
                Student Number: 1234598872          Grade:  11
                Birthdate:      01/02/2000          Gender: M
                State ID:       8923466789
                                
                Cumulative GPA (Weighted)       3.82
                Cumulative GPA (Unweighted)   3.46
                """;
        String regex = """
                Student\\sNumber:\\s(?<studentNum>\\d{10}).*
                """; //.* zero or more
        Pattern pat = Pattern.compile(regex, Pattern.DOTALL | Pattern.COMMENTS); //tells regular expression engine to match everything after dot
        Matcher mat = pat.matcher(transcript);
        //trigger the reg expression matcher to find a match
        if (mat.matches()) {

            //start with string literals to look for static words
            System.out.println(mat.group("studentNum"));
        }
    }
}
