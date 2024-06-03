package cs_assembly;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private final String input;
    private final List<Token> tokens;
    public Lexer(String input){
        this.input = input;
        this.tokens = new ArrayList<Token>();
    }

    private void tokenize(){}

    class Token{
        final TokenType type;
        final String value;

        Token(TokenType type, String value){
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
    enum TokenType{
        //all the tokens possible in our language
        //Token is
        CONFIG, UPDATE, COMPUTE, SHOW, CONFIGS, STRING, NUMBER, IDENTIFIER,
        REFERENCES
    }
}
