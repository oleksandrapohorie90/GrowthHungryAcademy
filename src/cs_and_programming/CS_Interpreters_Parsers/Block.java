package cs_and_programming.CS_Interpreters_Parsers;

import java.util.ArrayList;
import java.util.List;

public class Block extends ASTNode{

    public List<ASTNode> statements;

    public Block(List<ASTNode> statements) {
        this.statements = statements;
    }

    public void addStatement(ASTNode statement) {
        statements.add(statement);
    }

    @Override
    public void print(String indent) {
        //System.out.println(indent + "Block: ");
        for (ASTNode node : statements) {
            node.print(" ");
        }
    }
}
