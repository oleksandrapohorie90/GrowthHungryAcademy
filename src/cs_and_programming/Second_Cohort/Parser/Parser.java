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
        final String value;
        final ASTNode left;
        final ASTNode right;

        public BinaryNode(String value, ASTNode left, ASTNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static class IdentifierNode extends ASTNode {
        //everything in the node is immutable
        final String value;

        public IdentifierNode(String value) {
            this.value = value;
        }
    }

    static class NumberNode extends ASTNode {
        final String value;

        public NumberNode(String value) {
            this.value = value;
        }
    }
}
