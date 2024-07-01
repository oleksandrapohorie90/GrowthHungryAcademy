package cs_and_programming.CS_Interpreters_Semantic_Analysis;

import cs_and_programming.CS_Interpreters_Parsers.ASTNode;
import cs_and_programming.CS_Interpreters_Parsers.Token;

public class Var extends ASTNode {

    Token token;
    String name;

    public Var(Token token) {
        this.token = token;
        this.name = token.value;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent +"Var{"+name+'}');
    }
}
