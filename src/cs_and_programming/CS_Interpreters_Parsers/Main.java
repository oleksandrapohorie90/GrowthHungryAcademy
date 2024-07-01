package cs_and_programming.CS_Interpreters_Parsers;

import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserException {
        Lexer lexer = new Lexer("3 + 5 * (10 - 1); var x = 4 - 5; x = 1");
        List<Token> tokens = lexer.tokenize();
        Parser parser = new Parser(tokens);
        ASTNode root = parser.parse(); //later there will be Interpreter to pass on

        root.print("  ");

    }
}
