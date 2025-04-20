package cs_and_programming.Second_Cohort.Lexer.P_I;

import cs_and_programming.Lexerexception;

//raw input -> broken down into list of tokens
//we want to support basic operations x= 3 + 5 *6;
//we want to support some if (x < 0)

public class Lexer {
    //    public static List<String> tokenize(String input) {
//        List<String> tokens = new ArrayList<>();
//
//        //define token patterns in order
//        String[] tokenPatterns = {
//                "\\bif\\b",           //if
//                "\\belse\\b",         //else
//                "\\bprint\\b",        //print
//                "[a-zA-Z_][a-zA-Z0-9_]*",// identifiers (x, y, variable names)
//                "\\d+",               //numbers
//                "==|>=|<=|!=|>|<",    //comparison operators
//                "[+\\-*/=]",          //math and assignment
//                "[(){};]"             //punctuation
//        };
//
//        //combine them into one big regex
//        String combinedPattern = String.join("|", tokenPatterns);
//
//        //matcher to find all tokens
//        Matcher matcher = Pattern.compile(combinedPattern).matcher(input);
//
//        while (matcher.find()) {
//            tokens.add(matcher.group());
//        }
//
//        return tokens;
//    }
    private static final char EOF_CHAR = '\0';
    //private static final Set<String> KEYWORDS = new HashSet<>(Arrays.asList("if"));
    private final String input;
    private int position;
    private char currentChar;

    public Lexer(String input) {
        this.input = input;
        this.position = 0;
        this.currentChar = input == null || input.isEmpty() ? EOF_CHAR : input.charAt(position);
    }

    public Token nextToken() {
        while (currentChar != EOF_CHAR) {
            if (Character.isWhitespace(currentChar)) {
                skipWhiteSpace();
                continue;
            }
            if (Character.isDigit(currentChar)) {
                return readNumber();
            }
            if (Character.isLetter(currentChar)) {
                return readIdentifier();
            }
            switch (currentChar) {
                case '=':
                    advance();
                    return new Token(TokenType.ASSIGNMENT, "=");
                case '+':
                    advance();
                    return new Token(TokenType.PLUS, "+");
                case '-':
                    advance();
                    return new Token(TokenType.MINUS, "-");
                case '*':
                    advance();
                    return new Token(TokenType.MULTIPLY, "*");
                case ';':
                    advance();
                    return new Token(TokenType.SEPARATOR, ";");
                case '(':
                    advance();
                    return new Token(TokenType.OPEN_BRACKET, "(");
                case ')':
                    advance();
                    return new Token(TokenType.CLOSE_BRACKET, ")");
                case '{':
                    advance();
                    return new Token(TokenType.OPEN_CURLY_BRACKET, "{");
                case '}':
                    advance();
                    return new Token(TokenType.CLOSED_CURLY_BRACKET, "}");
                case '>':
                    advance();
                    return new Token(TokenType.GREATER_THAN, ">");
                case '<':
                    advance();
                    return new Token(TokenType.SMALLER_THAN, "<");
                case '%':
                    advance();
                    return new Token(TokenType.PERCENTAGE, "%");
                default:
                    throw new Lexerexception("Unsupported character: " + currentChar);
            }
        }
        return new Token(TokenType.EOF, "");
    }

    private Token readIdentifier() {
        StringBuilder builder = new StringBuilder();
        while (Character.isLetterOrDigit(currentChar)) {
            builder.append(currentChar);
            advance();
        }

        String value = builder.toString();

        if ("if".equals(value)) {
            return new Token(TokenType.IF, value);
        } else if ("else".equals(value)) {
            return new Token(TokenType.ELSE, value);
        } else if ("print".equals(value)) {
            return new Token(TokenType.PRINT, value);
        } else {
            return new Token(TokenType.IDENTIFIER, value);
        }
    }

    private Token readNumber() {
        StringBuilder builder = new StringBuilder();
        while (Character.isDigit(currentChar)) {
            builder.append(currentChar);
            advance();//to be able to move to another character
        }
        return new Token(TokenType.NUMBER, builder.toString());
    }

    private void skipWhiteSpace() {
        while (Character.isWhitespace(currentChar)) {
            advance();
        }
    }

    private void advance() {
        position++;
        currentChar = position < input.length() ? input.charAt(position)
                : EOF_CHAR;
    }

    public static class Token {
        public final TokenType tokenType;
        public final String value;

        public Token(TokenType tokenType, String value) {
            this.tokenType = tokenType;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Token {" +
                    "tokenType=" + tokenType +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public enum TokenType {
        NUMBER, IDENTIFIER, PLUS, EOF, ASSIGNMENT, SEPARATOR, MINUS, IF, MULTIPLY, OPEN_BRACKET, CLOSE_BRACKET, OPEN_CURLY_BRACKET, CLOSED_CURLY_BRACKET, GREATER_THAN, SMALLER_THAN, ELSE, PRINT,PERCENTAGE, DIVIDE
    }

}
