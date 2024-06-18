package cs_assembly.CS_Interpreters_Parsers;

public class BinaryOpNode extends ASTNode{
        //left node
        ASTNode left; // can be another binary operation
        //right node
        ASTNode right; // can be another binary operation
        Token operationToken;

        public BinaryOpNode(ASTNode left, ASTNode right, Token operationToken) {
            this.left = left;
            this.right = right;
            this.operationToken = operationToken;
        }
    }

