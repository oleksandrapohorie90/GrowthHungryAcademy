package cs_assembly;

import java.util.ArrayList;
import java.util.List;

import static cs_assembly.Lexer.TokenType.STRING;

public class Lexer {

    private final String input;
    private final List<Token> tokens;
    int current;


    public Lexer(String input) {
        this.input = input;
        this.tokens = new ArrayList<Token>();
        this.current = 0;
        tokenize();
    }

    private void tokenize() {
        while (current < input.length()) {
            char ch = input.charAt(current);
            switch (ch) {
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    current++;
                    break;
                case '=':
                    tokens.add(new Token(TokenType.ASSIGNMENT, "="));
                    current++;
                    break;
                case '+':
                case '-':
                case '/':
                case '*':
                    tokens.add(new Token(TokenType.OPERATOR, Character.toString(ch)));
                    current++;
                    break;

                case '"':
                    tokens.add(new Token(STRING, readString()));
                    break;

            }
        }
    }

    private String readString() {
        StringBuilder sb = new StringBuilder();
        current++;
        while (current < input.length() && input.charAt(current) != '"') {
            sb.append(input.charAt(current));
            current++;
        }
        return sb.toString();
    }

    static class Token {
        final TokenType type;
        final String value;

        Token(TokenType type, String value) {
            this.type = type;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Token{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }

    }

    enum TokenType {
        //all the tokens possible in our language
        //Token is
        CONFIG, UPDATE, COMPUTE, SHOW, CONFIGS, STRING, NUMBER, IDENTIFIER,
        REFERENCES, ASSIGNMENT, OPERATOR
    }
}
