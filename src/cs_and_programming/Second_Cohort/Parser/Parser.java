package cs_and_programming.Second_Cohort.Parser;

import cs_and_programming.CS_Interpreters_Parsers.ParserException;
import cs_and_programming.Second_Cohort.Lexer.P_I.Lexer;

public class Parser {
    /*
    <program> ::= <statement> | <program> <separator> <statement>
    <statement> ::= <expression>
    <separator> ::= ";"

    <expression> ::= <term> | <term> "+" <expression> | <term> "-" <expression>
    <term> ::= <factor> | <factor> "*" <term> | <factor> "/" <term> => 15 || 5*3 || 5+3
    <factor> ::= <number> | <identifier>

    <statement> ::= <assignment> | <expression>
    <assignment> ::= <identifier> "=" <expression>

    ignore this | "(" <expression> ")"
     */
    private final Lexer lexer;
    private Lexer.Token currentToken;
    public AssignmentNode assignmentNode;
    public BinaryNode binaryNode;
    public NumberNode numberNode;
    public IdentifierNode identifierNode;


    public Parser(Lexer lexer) {
        this.lexer = lexer;
        //assign the current token number or identifier
        this.currentToken = lexer.nextToken();
    }

    public ASTNode parse() {
        //return parseFactor();
        //return parseTerm();
        //return parseExpression();
        return parseStatement();
    }

    private ASTNode parseStatement() {
        //look ahead for assignment pattern: IDENTIFIER '=' ...
        // <statement> ::= <assignment> | <expression>
        // <assignment> ::= <identifier> "=" <expression>

        if (currentToken.tokenType == Lexer.TokenType.IDENTIFIER) { //x + 5
            String identifier = currentToken.value;
            consume(Lexer.TokenType.IDENTIFIER); //advance, move forward
            if (currentToken.tokenType == Lexer.TokenType.ASSIGNMENT) {
                consume(Lexer.TokenType.ASSIGNMENT);
                ASTNode expr = parseExpression();
                return new AssignmentNode(identifier, expr);
            }
        }
        //expression: 5 + 3 || 5 - 3
        //factor: is a number of identifier
        //term: 5 * 3 || 5 / 3
        //operator: +, -, *, /

        //fallback to just parsing as expression
        return parseExpression();
    }

    private ASTNode parseExpression() {

        ASTNode leftTerm = parseTerm();

        if (currentToken.tokenType == Lexer.TokenType.PLUS || currentToken.tokenType == Lexer.TokenType.MINUS) {
            //if we have '+' and '-' we need to consume and proceed to the next token
            Lexer.TokenType operation = currentToken.tokenType;
            consume(currentToken.tokenType);

            //rightTerm is parseExpression()
            return new BinaryNode(operation, leftTerm, parseExpression());
        }

        return leftTerm;
    }

    public ASTNode parseTerm() {

        //<term> ::= <factor> | <factor> "*" <term> | <factor> "/" <term>

        //this is our left
        ASTNode leftNode = parseFactor();

        if (currentToken.tokenType == Lexer.TokenType.MULTIPLY || currentToken.tokenType == Lexer.TokenType.DIVIDE) {
            //if we have '*' and '/' we need to consume and proceed to the next token
            Lexer.TokenType operation = currentToken.tokenType;
            consume(currentToken.tokenType);

            ASTNode rightNode = parseTerm();
            return new BinaryNode(operation, leftNode, rightNode);

        }
        return leftNode;
    }

    public ASTNode parseFactor() {

        //go to lexer and parse everything you see
        //we can only receive a factor -> identifier or number
        if (currentToken.tokenType == Lexer.TokenType.NUMBER) {
            String value = currentToken.value;
            consume(Lexer.TokenType.NUMBER);
            return new NumberNode(value);
        }
        if (currentToken.tokenType == Lexer.TokenType.IDENTIFIER) {
            String value = currentToken.value;
            consume(Lexer.TokenType.IDENTIFIER);
            return new IdentifierNode(value);
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

//    public void print(ASTNode node, int indent) {
//        //System.out.println("method is called ");
//        String indentStr = "  ".repeat(indent);
//        //depth of search
//        if (node instanceof Parser.NumberNode) {
//            System.out.println(indentStr + "Number: " + ((Parser.NumberNode) node).value);
//        } else if (node instanceof Parser.IdentifierNode) {
//            System.out.println(indentStr + "Identifier: " + ((Parser.IdentifierNode) node).value);
//        } else if (node instanceof Parser.BinaryNode) {
//            Parser.BinaryNode bin = (Parser.BinaryNode) node;
//            System.out.println(indentStr + "BinaryOp: " + bin.operation);
//            print(bin.left, indent + 1);
//            print(bin.right, indent + 1);
//        } else {
//            System.out.println(indentStr + "Unknown node");
//        }
//    }

    //we need a node, class ASTNODE
    public static class ASTNode {
        //all leafs will be identifier or number, leaf of the tree doesnt have children
    }

    static class AssignmentNode extends ASTNode {
        final String identifier;
        final ASTNode expression;

        public AssignmentNode(String identifier, ASTNode expression) {
            this.identifier = identifier;
            this.expression = expression;
        }

        @Override
        public String toString() {
            return "Assignment: = ";
        }

    }

    static class BinaryNode extends ASTNode {
        final Lexer.TokenType operation;
        final ASTNode left;
        final ASTNode right;

        public BinaryNode(Lexer.TokenType operation, ASTNode left, ASTNode right) {
            //has operation, left and right
            /*
            *
           / \
          x   y
             */
            this.operation = operation;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "BinaryOperation: " + operation.toString()
                    + "\n\t" + left.toString() +
                    "\n\t" + right.toString();
        }

    }

    public void print(ASTNode node) {
        System.out.println(node.toString());
    }

    static class IdentifierNode extends ASTNode {
        //everything in the node is immutable
        final String value;

        public IdentifierNode(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "IdentifierNode: "+value;
        }
    }

    static class NumberNode extends ASTNode {
        final String value;

        public NumberNode(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "NumberNode: " + value;
        }
    }
}
