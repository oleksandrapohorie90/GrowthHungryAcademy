package cs_and_programming.Second_Cohort.Lexer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer();

        String code = """
            config "num_users" = 100
            update "num_users" = 200
            compute "total_requests" = %num_users * %request_rate
            show configs
        """;

        List<Token> tokens = lexer.tokenize(code);

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}

