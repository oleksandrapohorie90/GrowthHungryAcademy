package cs_and_programming.CS_Interpreters_Parsers;

public class Vardecl extends ASTNode{
    public Var varNode;
    public ASTNode expr;

    //declaration has below
    public Vardecl(Var varNode, ASTNode expr) {
        this.varNode = varNode;
        this.expr = expr;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent +"VarDecl{" + varNode.name + '}');
        expr.print(indent + indent);
    }
}
