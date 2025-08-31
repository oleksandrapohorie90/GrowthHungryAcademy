package cs_and_programming.Recap_SimpleDSL;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class Lexer {
    //will have one method tokenize and constructor
    private String input;
    private int position;

    public Lexer(String rawInput) {
        input = rawInput;
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (position < input.length()) {
            char c = input.charAt(position);
            if (Character.isWhitespace(c)) {
                position++;
                continue;
            }
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (position < input.length() && Character.isDigit(input.charAt(position))) {
                    sb.append(input.charAt(position++));
                }
                tokens.add(new Token(TokenType.NUM, sb.toString()));
            } else if (Character.isLetter(c)) {
                StringBuilder sb = new StringBuilder();
                while (position < input.length() && Character.isLetter(input.charAt(position))) {
                    sb.append(input.charAt(position++));
                }
                switch (sb.toString()) {
                    case "ADD":
                        tokens.add(new Token(TokenType.ADD, sb.toString()));
                        break;
                    case "SUB":
                        tokens.add(new Token(TokenType.SUB, sb.toString()));
                        break;
                    case "MUL":
                        tokens.add(new Token(TokenType.MUL, sb.toString()));
                        break;
                    case "DIV":
                        tokens.add(new Token(TokenType.DIV, sb.toString()));
                        break;
                    case "LET":
                        tokens.add(new Token(TokenType.LET, sb.toString()));
                        break;
                    default:
                        try {
                            Integer i = Integer.parseInt(sb.toString());
                            tokens.add(new Token(TokenType.NUM, sb.toString()));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid token");
                        }
                }
            }
            tokens.add(new

                    Token(TokenType.EOF, "EOF"));
            return tokens;
        }
    }
