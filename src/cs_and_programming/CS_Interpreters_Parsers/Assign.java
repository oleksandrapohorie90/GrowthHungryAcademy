package cs_and_programming.CS_Interpreters_Parsers;

public class Assign extends ASTNode{
    private String variable;
    private ASTNode value;

    public Assign(String variable, ASTNode value) {
        this.variable = variable;
        this.value = value;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent+ "Assignment: " +
                variable + " = ");
        value.print(indent + " ");
    }
}
