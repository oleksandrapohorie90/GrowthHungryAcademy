package cs_and_programming.Recap_SimpleDSL;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    //will have one method tokenize and constructor
    private String input;

    public Lexer(String rawInput) {
        input = rawInput;
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        String[] temp = input.split(" ");
        for (String t : temp) {
            switch (t) {
                case "ADD":
                    tokens.add(new Token(TokenType.ADD, t));
                    break;
                case "SUB":
                    tokens.add(new Token(TokenType.SUB, t));
                    break;
                case "MUL":
                    tokens.add(new Token(TokenType.MUL, t));
                    break;
                case "DIV":
                    tokens.add(new Token(TokenType.DIV, t));
                    break;
                default:
                    try {
                        Integer i = Integer.parseInt(t);
                        tokens.add(new Token(TokenType.NUM, t));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid token");
                    }
            }
        }
        tokens.add(new Token(TokenType.EOF, "EOF"));
        return tokens;
    }
}
