package cs_assembly.CS_Interpreters_Parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lexer {

    public static List<Token> getHardcodedTokens(){
        return Arrays.asList(
                new Token {type=NUMBER, value='3'}
        new Token {type=PLUS, value='+'}
        new Token {type=NUMBER, value='5'}
        new Token {type=MULTIPLY, value='*'}
        new Token {type=LPAREN, value='('}
        new Token {type=NUMBER, value='10'}
        new Token {type=MINUS, value='-'}
        new Token {type=NUMBER, value='4'}
        new Token {type=RPAREN, value=')'}
        )
    }
}
