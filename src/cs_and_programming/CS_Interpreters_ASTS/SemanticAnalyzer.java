package cs_and_programming.CS_Interpreters_ASTS;

import cs_and_programming.CS_Interpreters_Parsers.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SemanticAnalyzer {
    private final Stack<Set<String>> scopes = new Stack<>();
//checks if var are used after they are declared

    //parser returns the root node
    //go thru all the children and check if everything is good
    public void visit(ASTNode node) throws ParserException {
        //if smth is wrong we should throw an exception to know whats wrong
        //go thru each node

        if (node instanceof BinaryOpNode) {
            visit(((BinaryOpNode) node).left);
            visit(((BinaryOpNode) node).right);

        } else if (node instanceof NumberNode) {
            //nothing, semantic analyzer doesn't return anything
            //unless there is an error

        } else if (node instanceof Vardecl varDecl) {
            String varName = varDecl.varNode.name;
            if (!isvariableDefined(varName)) {
                throw new ParserException("Identifier already defined: " + varName);

            }
            //put varName to current scope
            scopes.peek().add(varName);//take the latest element, declare var in scope

        } else if (node instanceof Var) {
            String varName = ((Var) node).name;
            if (!isvariableDefined(varName)) {
                throw new ParserException("Unexpected identifier: " + varName);

            }

        } else if (node instanceof Assign assignNode) {
            String varName = assignNode.left.name;
            if (!isvariableDefined(varName)) {
                throw new ParserException("Unexpected identifier: " + varName);

            }
            visit(assignNode.right);

        } else if (node instanceof Block block) {
            scopes.push(new HashSet<>());//enter a new scope
            //enter scope
            for (ASTNode statement : block.statements) {
                visit(statement);
            }
            //exit scope
            scopes.pop();
        } else {
            throw new ParserException("Unexpected AST Node: " + node.getClass().getCanonicalName());
        }

    }

    private boolean isvariableDefined(String varName){
        for(Set<String> scope: scopes){
            if(scope.contains(varName))return true;
        }
        return false;
    }
}


