package cs_assembly;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private final String input;
    private final List<Token> tokens;
    public Lexer(String input){
        this.input = input;
        this.tokens = new ArrayList<Token>();
    }

    private void tokenize(){}
    private static class Token{}
}
