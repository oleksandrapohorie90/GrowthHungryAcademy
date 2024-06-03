package cs_assembly;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private final String input;
    private final List<Token> tokens;
    int current;


    public Lexer(String input){
        this.input = input;
        this.tokens = new ArrayList<Token>();
        this.current = 0;
        tokenize();
    }

    private void tokenize(){
        while(current<input.length())
    }

    static class Token{
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
