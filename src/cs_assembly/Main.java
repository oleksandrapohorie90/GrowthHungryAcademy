package cs_assembly;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String input = """
                config "num_users" = 100
                config "num_requests" = 100
                compute "result" = %num_users + %num_requests
                update "num_users" = 200               
                loop "i" from 1 to 5
                compute "iteration_result_%i" = %num_users * %i
                end               
                    if %num_users > 1000
                update "status" = "high load"
                    else 
                    update "status" = "normal load"
                end
                """;
//lexer is some collections that we can iterate over
        Lexer lexer = new Lexer(input);
        for(Lexer.Token token : lexer){
            System.out.println(token);
        }

        //use java to create lexer that will parse to token types
//        ArrayList<Lexer.Token> tokens = new ArrayList<>();
//
//        tokens.add(new Lexer.Token(Lexer.TokenType.CONFIG, "Config"));
//        tokens.add(new Lexer.Token(Lexer.TokenType.STRING, "num_users"));
//        tokens.add(new Lexer.Token(Lexer.TokenType.NUMBER, "100"));
//
//        for(Lexer.Token token : tokens){
//            System.out.println(token);
//        }
    }

}
