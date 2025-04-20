package cs_and_programming.Second_Cohort.Parser;

import cs_and_programming.Second_Cohort.Lexer.P_I.Lexer;

public class Parser {
    /*
    <program> ::= <statement> | <program> <separator> <statement>
    <statement> ::= <expression>
    <separator> ::= ";"

    <expression> ::= <term> | <term> "+" <expression> | <term> "-" <expression>
    <term> ::= <factor> | <factor> "*" <term> | <factor> "/" <term>
    <factor> ::= <number> | <identifier>

    ignore this | "(" <expression> ")"
     */
    private final Lexer lexer;
    private Lexer.Token currentToken;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        //assign the current token number or identifier
        this.currentToken = lexer.nextToken();
    }

    public ASTNode parse() {

        //go to lexer and parse everything you see
        //we can only receive a factor -> identifier or number
        if (currentToken.tokenType == Lexer.TokenType.NUMBER) {
            return new NumberNode(currentToken.value);
        }
        if (currentToken.tokenType == Lexer.TokenType.IDENTIFIER) {
            return new IdentifierNode(currentToken.value);
        }
        return null;
    }

    //we need a node, class ASTNODE
    static class ASTNode {
        //all leafs will be identifier or number, leaf of the tree doesnt have children
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
