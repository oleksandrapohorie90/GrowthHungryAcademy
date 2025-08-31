package cs_and_programming.Recap_SimpleDSL;

import java.util.List;

public class Main {
    /*
    PROGRAM   := STATEMENT+
    STATEMENT := ASSIGNMENT | EXPRESSION
    ASSIGNMENT:= "LET" IDENTIFIER
    ARGUMENT  := NUMBER | IDENTIFIER
    EXPRESSION:= OPERATION ARGUMENT ARGUMENT
    OPERATION := "ADD" | "SUB" | "MUL" | "DIV"
    NUMBER    := [0-9]+
    IDENTIFIER:= [A-ZA-Z_][A-ZA-Z0-9_]*
     */
    public static void main(String[] args) {
        Lexer lexer = new Lexer("LET _x 5 ADD 2_x");
        List<Token> tokens = lexer.tokenize();
        tokens.forEach(t -> System.out.println(t));
        Parser parser = new Parser(tokens);
        parser.parse();
    }
}
