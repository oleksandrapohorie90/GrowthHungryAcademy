package cs_and_programming.Recap_SimpleDSL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    private List<Token> tokens;
    private int position;
    private Map<String,Integer> context = new HashMap<>();

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void parse() {
        while (tokens.get(position).type != TokenType.EOF) {
            if (tokens.get(position).type == TokenType.LET) {
                parseAssignment();
            } else {
                //parseExpression();
            }

//            int left = Integer.parseInt(tokens.get(position + 1).value);
//            int right = Integer.parseInt(tokens.get(position + 3).value);
//            Token operation = tokens.get(position);
//            switch (operation.type) {
//                case ADD:
//                    System.out.println(left + right);
//                    break;
//                case SUB:
//                    System.out.println(left - right);
//                    break;
//                case MUL:
//                    System.out.println(left * right);
//                    break;
//                case DIV:
//                    System.out.println(left / right);
//                    break;
//                case LET:
//                    System.out.println(left / right);
//                    break;
//            }
//
//            position += 3;
//        }
        }
    }

    private void parseAssignment(){

        //String identifier = tokens.get(position++);
    }

}


