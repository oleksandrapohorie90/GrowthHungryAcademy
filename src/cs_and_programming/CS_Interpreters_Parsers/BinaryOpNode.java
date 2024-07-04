package cs_and_programming.CS_Interpreters_Parsers;

public class BinaryOpNode extends ASTNode{
        //left node
        public ASTNode left; // can be another binary operation
        //right node
        public ASTNode right; // can be another binary operation
        public Token operationToken;

        public BinaryOpNode(ASTNode left, ASTNode right, Token operationToken) {
            this.left = left;
            this.right = right;
            this.operationToken = operationToken;
        }
    @Override
    public void print(String indent) {
        System.out.println(indent + "BinaryOp{" + operationToken.value + "}");
//        if (left != null) {
//            left.print(indent + "  ");
//        } else {
//            System.out.println(indent + "  null");
//        }
//        if (right != null) {
//            right.print(indent + "  ");
//        } else {
//            System.out.println(indent + "  null");
//        }
        left.print(indent+indent);
        right.print(indent+indent);
    }
}

