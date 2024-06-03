package cs_assembly;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String input = """
                config "num_users" = 100
                update "num_requests" = 200
                compute "result" = %num_users + %num_requests
                update "num_users" = 200
                """;

        Lexer lexer = new Lexer(input);
        for(Lexer.Token token : lexer){
            System.out.println(token);
        }

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
