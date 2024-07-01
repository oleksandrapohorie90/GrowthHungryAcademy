package cs_and_programming.CS_Interpreters_Parsers;

public class Token {

    public enum Type{
        NUMBER, PLUS, MINUS, MULTIPLY, DIVIDE, LPAREN, RPAREN
    }

    public final Type type;

    public final String value;

    public Token (Type type, String value){
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
