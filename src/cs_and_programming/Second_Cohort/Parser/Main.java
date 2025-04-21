package cs_and_programming.Second_Cohort.Parser;

import cs_and_programming.Second_Cohort.Lexer.P_I.Lexer;

public class Main {
    public static void main(String[] args) {
        //String rawInput = "43 + x";
        String rawInput = "5 + 3 * x";
        Lexer lexer = new Lexer(rawInput);

        Lexer.Token token;
        do {
            token = lexer.nextToken();
            System.out.println(token);
        } while (token.tokenType != Lexer.TokenType.EOF);

        //parser will be going through each token and asking lexer give me next token give me next token, character by character
        Parser parser = new Parser(new Lexer(rawInput));
        Parser.ASTNode tree = parser.parse();
        parser.print(tree, 0);
    }
}
