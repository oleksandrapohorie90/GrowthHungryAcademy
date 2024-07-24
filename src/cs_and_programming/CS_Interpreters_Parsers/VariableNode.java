package cs_and_programming.CS_Interpreters_Parsers;

public class VariableNode extends ASTNode{
    Token variableToken;

    public VariableNode(Token variableToken) {
        this.variableToken = variableToken;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent+ "VariableNode{" +
                variableToken.value +
                '}');
    }
}
