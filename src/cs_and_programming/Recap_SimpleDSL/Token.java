package cs_and_programming.Recap_SimpleDSL;

public class Token {
    private TokenType type;
    private String value;

    public Token(TokenType type, String value) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
