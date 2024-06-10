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

    public ASTNode parse() {
        return term();
    }

    private ASTNode term() {

        ASTNode node = factor();
        while (currentToken != null && currentToken.type == Type.MULTIPLY || currentToken.type == Type.DIVIDE) {
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
        return null;
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
