package cs_and_programming.Recap_SimpleDSL;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer("ADD 5 3 SUB 7 6  DIV 10 0");
        List<Token> tokens = lexer.tokenize();

        tokens.forEach(t -> System.out.println(t));
        Parser parser = new Parser(tokens);
        parser.parse();
    }
}
