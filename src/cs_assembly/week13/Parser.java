package cs_assembly.week13;

public class Parser {
    abstract class ASTNode{

    }

    class Number extends ASTNode{

        Tokens numberToken;

        public Number(Tokens numberToken) {
            this.numberToken = numberToken;
        }
    }
    class BinaryOp extends ASTNode{

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
