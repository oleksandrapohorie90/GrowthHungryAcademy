package cs_and_programming.CS_Interpreters_Parsers;

public class Assign extends ASTNode{

    Var left;
    ASTNode right;

    public Assign(Var left, ASTNode right) {
     this.left = left;
     this.right = right;
    }

    @Override
    public void print(String indent) {

    }
}
