package cs_assembly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static cs_assembly.Lexer.TokenType.*;

public class Lexer implements Iterable<Lexer.Token> {

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
                    current++;
                    break;
                case '%':
                    tokens.add(new Token(REFERENCES, readReference()));
                    break;
                default:
                    if (isDigit(ch)) {
                        tokens.add(new Token(NUMBER, readNumber()));
                    } else if (isAlpha(ch)) {
                        String identifier = readIdentifier();
                        tokens.add(new Token(deriveTokenType(identifier), identifier));
                    } else {
                        throw new Lexerexception("unsupported char " + ch);
                    }
            }
        }
    }
//based on this identifier is it configs is it what, everything we dont know will be identifier
    //otherwise we put here cases
    private TokenType deriveTokenType(String identifier) {
        return switch (identifier) {
            case "config" -> CONFIG;
            case "update" -> UPDATE;
            case "compute" -> COMPUTE;
            case "show" -> SHOW;
            case "configs" -> CONFIGS;
            default -> IDENTIFIER;
        };
    }
//some special char we cannot process, white space
    private String readIdentifier() {
        StringBuilder sb = new StringBuilder();
        while (current < input.length() && isAlphanumeric(input.charAt(current))) {
            sb.append(input.charAt(current));
            current++;
        }
        return sb.toString();
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

    private String readReference() {
        StringBuilder sb = new StringBuilder();
        current++;
        while (current < input.length() && isAlphanumeric(input.charAt(current))) {
            sb.append(input.charAt(current));
            current++;
        }
        return sb.toString();
    }

    private boolean isAlphanumeric(char ch) {
        return isAlpha(ch) | isDigit(ch);
    }

    private boolean isAlpha(char ch) {
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') || ch == '_';
    }

    private boolean isDigit(char ch) {
        return '0' <= ch && ch <= '9';
    }

    private String readNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        while (current < input.length() && isDigit(input.charAt(current))) {
            stringBuilder.append(input.charAt(current));
            current++;
        }
        return stringBuilder.toString();
    }
//because implements Iterable
    @Override
    public Iterator<Token> iterator() {
        return tokens.iterator();
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
