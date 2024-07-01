package cs_and_programming.CS_Interpreters_Parsers;

public class Assign extends ASTNode{

    Var left;
    Token op;

    ASTNode right;

    public Assign(Var left, Token op, ASTNode right) {
     this.left = left;
     this.op = op;
     this.right = right;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent+ "Assignment: " +
                variable + " = ");
        value.print(indent + " ");
    }
}
