package cs_assembly;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //use java to create lexer that will parse to token types
        ArrayList<Lexer.Token> tokens = new ArrayList<>();

        tokens.add(new Lexer.Token(Lexer.TokenType.CONFIG, "Config"));
        tokens.add(new Lexer.Token(Lexer.TokenType.STRING, "num_users"));
        tokens.add(new Lexer.Token(Lexer.TokenType.NUMBER, "100"));

        for(Lexer.Token token : tokens){
            System.out.println(token);
        }
    }

}
