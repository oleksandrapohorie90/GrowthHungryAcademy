package cs_and_programming.Second_Cohort.Lexer.P_I;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    public static List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();

        //define token patterns in order
        String[] tokenPatterns = {
                "\\bif\\b",           //if
                "\\belse\\b",         //else
                "\\bprint\\b",        //print
                "[a-zA-Z_][a-zA-Z0-9_]*",// identifiers (x, y, variable names)
                "\\d+",               //numbers
                "==|>=|<=|!=|>|<",    //comparison operators
                "[+\\-*/=]",          //math and assignment
                "[(){};]"             //punctuation
        };

        //combine them into one big regex
        String combinedPattern = String.join("|", tokenPatterns);

        //matcher to find all tokens
        Matcher matcher = Pattern.compile(combinedPattern).matcher(input);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }
}
