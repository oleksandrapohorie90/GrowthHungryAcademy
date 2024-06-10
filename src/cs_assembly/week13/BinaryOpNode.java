package cs_assembly.week13;

public class BinaryOpNode extends ASTNode{
    public BinaryOpNode(ASTNode left, ASTNode right, Tokens operationToken) {
        this.left = left;
        this.right = right;
        this.operationtoken = operationToken;
    }


}
