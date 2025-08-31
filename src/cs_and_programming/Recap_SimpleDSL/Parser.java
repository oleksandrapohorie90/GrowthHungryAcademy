package cs_and_programming.Recap_SimpleDSL;

import java.util.List;

public class Parser {
    private List<Token> tokens;
    private int position;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void parse() {
        while (tokens.get(position).type != TokenType.EOF) {
            int left = Integer.parseInt(tokens.get(position + 1).value);
            int right = Integer.parseInt(tokens.get(position + 3).value);
            Token operation = tokens.get(position);
            switch (operation.type) {
                case ADD:
                    System.out.println(left + right);
                    break;
                case SUB:
                    System.out.println(left - right);
                    break;
                case MUL:
                    System.out.println(left * right);
                    break;
                case DIV:
                    System.out.println(left / right);
                    break;
            }

            position += 3;
        }
    }
}
