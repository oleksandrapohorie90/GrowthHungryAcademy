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
                Student\\sNumber:\\s(?<studentNum>\\d{10}).*#Grab student number
                Grade:\\s+(?<grade>\\d{1,2}).* #Grab student grade
                Birthdate:\\s+(?<birthMonth>\\d{2})/(?<birthDay>\\d{2})/(?<birthYear>\\d{4}).* 
                Gender:\\s+(?<gender>\\w+)\\b.* 
                State\\sID:\\s+(?<stateID>\\d+)\\b.*? #it goes forward bc of ? till word Cumulative 
                Cumulative.*?(?<weightedGPA>[\\d\\.]+)\\b.* 
                #Weighted\\)\\s+(?<weightedGPA>[\\d\\.]+)\\b.* 
                #UnWeighted\\)\\s+(?<unWeightedGPA>[\\d\\.]+)\\b.* 
                """; //.* zero or more
        Pattern pat = Pattern.compile(regex, Pattern.DOTALL | Pattern.COMMENTS); //tells regular expression engine to match everything after dot
        Matcher mat = pat.matcher(transcript);
        //trigger the reg expression matcher to find a match
        if (mat.matches()) {

            //start with string literals to look for static words
            System.out.println(mat.group("studentNum"));
            System.out.println(mat.group("grade"));
            System.out.println(mat.group("birthMonth"));
            System.out.println(mat.group("birthDay"));
            System.out.println(mat.group("birthYear"));
            System.out.println(mat.group("gender"));
            System.out.println(mat.group("stateID"));
            System.out.println(mat.group("weightedGPA"));
            System.out.println(mat.group("unWeightedGPA"));
        }
    }
}
