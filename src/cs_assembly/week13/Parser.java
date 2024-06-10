package cs_assembly.week13;

import java.lang.reflect.Type;
import java.util.List;

public class Parser {
    private final List<Tokens> tokens;
    private int currentPos; //num of tokens
    private Tokens currentToken;

    public Parser(List<Tokens> tokens) {
        this.tokens = tokens;
        currentPos = 0;
        currentToken = tokens.get(currentPos);
    }
    private ASTNode expression() {

        ASTNode node = term();
        while (currentToken != null && (currentToken.type == Type.PLUS || currentToken.type == Type.MINUS)) {
            Tokens token = currentToken;
            consume(currentToken.type);
            node = new BinaryOpNode(node, term(), token);
        }
    }
    public ASTNode parse() {
        return term();
    }

    private ASTNode term() {

        ASTNode node = factor();
        while (currentToken != null && (currentToken.type == Type.MULTIPLY || currentToken.type == Type.DIVIDE)) {
            Tokens token = currentToken;
            consume(currentToken.type);
            node = new BinaryOpNode(node, factor(), token);
        }
    }

    private void consume(Type type) {
        if (currentToken.type == type) {
            currentPos++;
            if (currentPos < tokens.size()) {
                currentToken = tokens.get(currentPos);
            } else {
                currentToken = null;

            }
        } else {
            throw new Parserexception("unexpected token " + type)
        }
    }

    private ASTNode factor() {
        //factor is just an expression or a number
        //it has to be a number token and we just return it
        //we are pointing into a token

        //now it could be a paranthesis or a number
        Tokens token = currentToken;
        if(token.type==Tokens.type.NUMBER) {
            consume(Type.NUMBER);
            return new NumberNode(token);
        }

        if (token.type == Type.LPAREN){
            consume(Tokens.type.LPAREN);
        }
        throw  new Parserexception("unexpected token found : "+token);

    }

    abstract class ASTNode {

    }

    class Number extends ASTNode {

        Tokens numberToken;
        private final int value;

        public Number(Tokens numberToken) {
            this.numberToken = numberToken;
            this.value = Integer.parseInt(value);
        }
    }

    class BinaryOp extends ASTNode {

        //left node
        ASTNode left;
        //right node
        ASTNode right;
        Tokens operationToken;

        public BinaryOp(ASTNode left, ASTNode right, Tokens operationToken) {
            this.left = left;
            this.right = right;
            this.operationToken = operationToken;
        }
    }


}
