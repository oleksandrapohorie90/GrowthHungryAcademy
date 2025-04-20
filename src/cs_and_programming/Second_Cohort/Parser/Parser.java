package cs_and_programming.Second_Cohort.Parser;

import cs_and_programming.CS_Interpreters_Parsers.ParserException;
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
        return parseFactor();
    }

    public ASTNode parseTerm() {

        //<term> ::= <factor> | <factor> "*" <term> | <factor> "/" <term>

        //this is our left
        ASTNode leftNode = parseFactor();

        if (currentToken.tokenType == Lexer.TokenType.EOF) {
            return leftNode;
        }
        if (currentToken.tokenType == Lexer.TokenType.MULTIPLY || currentToken.tokenType == Lexer.TokenType.DIVIDE) {
            //if we have '*' and '/' we need to consume and proceed to the next token
            Lexer.TokenType operation = currentToken.tokenType;
            consume(currentToken.tokenType);

            ASTNode rightNode = parseTerm();
            return new BinaryNode(operation, leftNode, rightNode);

        }
        throw new IllegalArgumentException("Unexpected token type received: " + currentToken.tokenType.name());
    }

    public ASTNode parseFactor() {

        //go to lexer and parse everything you see
        //we can only receive a factor -> identifier or number
        if (currentToken.tokenType == Lexer.TokenType.NUMBER) {
            consume(Lexer.TokenType.NUMBER);
            return new NumberNode(currentToken.value);
        }
        if (currentToken.tokenType == Lexer.TokenType.IDENTIFIER) {
            consume(Lexer.TokenType.NUMBER);
            return new IdentifierNode(currentToken.value);
        }
        throw new IllegalArgumentException("Unexpected token type received: " + currentToken.tokenType.name());
    }

    private void consume(Lexer.TokenType tokenType) {
        //if the type of current token is the type we need and move to the next token
        if (currentToken.tokenType == tokenType) {
            currentToken = lexer.nextToken();
        } else {
            throw new ParserException("Unexpected token: " + currentToken.tokenType.name());
        }
    }

    //we need a node, class ASTNODE
    static class ASTNode {
        //all leafs will be identifier or number, leaf of the tree doesnt have children
    }

    static class BinaryNode extends ASTNode {
        final Lexer.TokenType operation;
        final ASTNode left;
        final ASTNode right;

        public BinaryNode(Lexer.TokenType operation, ASTNode left, ASTNode right) {
            //has operation, left nd right
            /*
            *
           / \
          x   y
             */
            this.operation = operation;
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
