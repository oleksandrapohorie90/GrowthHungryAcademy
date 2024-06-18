package cs_assembly.CS_Interpreters_Parsers;

import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserException {
        List<Token> tokens = Lexer.getHardcodedTokens();
        Parser parser = new Parser(tokens);
        ASTNode root = parser.parse(); //later there will be Interpreter to pass on

        root.print("  ");

    }
}
