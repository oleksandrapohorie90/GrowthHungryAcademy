package cs_and_programming.Second_Cohort.Parser;

import cs_and_programming.Second_Cohort.Lexer.P_I.Lexer;

public class Parser {
    private final Lexer lexer;
    private Lexer.Token currentToken;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    //we need a node, class ASTNODE
    static class ASTNode {

    }

    static class BinaryNode extends ASTNode {

    }

    static class IdentifierNode extends ASTNode {

    }

    static class NumberNode extends ASTNode {

    }
}
