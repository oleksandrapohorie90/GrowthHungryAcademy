package cs_and_programming.Second_Cohort.Lexer.P_I;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String rawInput = "xyz = 5465 +6 \n m = 5 * 7";
        Lexer lexer = new Lexer(rawInput);

        Lexer.Token token;
        do {
            token = lexer.nextToken();
            System.out.println(token);
        } while (token.tokenType != Lexer.TokenType.EOF);
//        String code = """
//            x = 5;
//            if (x > 3) {
//                y = x + 2;
//            } else {
//                y = x * (2 + 3);
//            }
//            print y;
//        """;

        //List<String> tokens = Lexer.tokenize(code);
        //System.out.println(tokens);
    }
}
