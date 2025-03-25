package cs_and_programming.Second_Cohort.Lexer;

import java.util.*;
import java.util.regex.*;

public class Lexer {
    private static class TokenPattern {
        String type;
        Pattern pattern;

        TokenPattern(String type, String regex) {
            this.type = type;
            this.pattern = Pattern.compile("^" + regex);
        }
    }

    private List<TokenPattern> tokenPatterns = new ArrayList<>();

    public Lexer() {
        // Order matters — keywords first
        tokenPatterns.add(new TokenPattern("CONFIG", "config"));
        tokenPatterns.add(new TokenPattern("UPDATE", "update"));
        tokenPatterns.add(new TokenPattern("COMPUTE", "compute"));
        tokenPatterns.add(new TokenPattern("SHOW", "show"));
        tokenPatterns.add(new TokenPattern("EQUALS", "="));
        tokenPatterns.add(new TokenPattern("ASTERISK", "\\*"));
        tokenPatterns.add(new TokenPattern("STRING", "\"[a-zA-Z_][a-zA-Z0-9_]*\""));
        tokenPatterns.add(new TokenPattern("VARIABLE", "%[a-zA-Z_][a-zA-Z0-9_]*"));
        tokenPatterns.add(new TokenPattern("NUMBER", "\\d+(\\.\\d+)?"));
        tokenPatterns.add(new TokenPattern("IDENTIFIER", "[a-zA-Z_][a-zA-Z0-9_]*"));
        tokenPatterns.add(new TokenPattern("WHITESPACE", "[ \t\n\r]+"));
        tokenPatterns.add(new TokenPattern("LOOP", "loop"));
        tokenPatterns.add(new TokenPattern("FROM", "from"));
        tokenPatterns.add(new TokenPattern("TO", "to"));
        tokenPatterns.add(new TokenPattern("IF", "if"));
        tokenPatterns.add(new TokenPattern("ELSE", "else"));
        tokenPatterns.add(new TokenPattern("END", "end"));
        tokenPatterns.add(new TokenPattern("GREATER_THAN", ">"));

    }

    public List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();
        while (!input.isEmpty()) {
            boolean matched = false;
            for (TokenPattern tp : tokenPatterns) {
                Matcher matcher = tp.pattern.matcher(input);
                if (matcher.find()) {
                    String value = matcher.group();
                    if (!tp.type.equals("WHITESPACE")) {
                        tokens.add(new Token(tp.type, value));
                    }
                    input = input.substring(value.length());
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                throw new RuntimeException("Unexpected character: " + input.charAt(0));
            }
        }
        return tokens;
    }
}

