package cs_and_programming.CS_Interpreters_ASTS;

import cs_and_programming.CS_Interpreters_Parsers.*;

import java.util.Set;
import java.util.Stack;

public class SemanticAnalyzer {
        private final Stack<Set<String>> scopes = new Stack<>();

        //parser returns the root node
        //go thru all the children and check if everything is good
        public void visit(ASTNode node) throws ParserException {
            //if smth is wrong we should throw an exception to know whats wrong
            //go thru each node

            if(node instanceof BinaryOpNode){
                visit(((BinaryOpNode)node).left);
                visit(((BinaryOpNode)node).right);

            }else if (node instanceof NumberNode){
                //nothing, semantic analyzer doesn't return anything
                //unless there is an error

            }else if (node instanceof Vardecl){
                //Vardecl varDeclNode = (Var)

            }else if (node instanceof VariableNode){
                String varName= ((Var)node).name;
                if(!isvariableDefined(varName)){
                    throw new ParserException("Unexpected identifier: " + varName);

                }

            }else if (node instanceof Assign assignNode){
                String varName = assignNode.left.name;
                if(!isvariableDefined(varName)){
                    throw new ParserException("Unexpected identifier: " + varName);

                }
                visit(assignNode.right);

            }else if (node instanceof Block){

            } else {
                throw new ParserException("Unexpected AST Node: " + node.getClass().getCanonicalName());
            }

        }
    }


