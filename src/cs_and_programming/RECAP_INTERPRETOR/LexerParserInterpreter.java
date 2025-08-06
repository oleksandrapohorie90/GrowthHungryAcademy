package cs_and_programming.RECAP_INTERPRETOR;

public class LexerParserInterpreter {
    /*
    ADD 5 3
    SUB 10 4
    MUL 2 8
    DIV 20 5
     */
//+ FROM 1 TO N
// * FROM 0 TO N

    /**
     * BNF RULE/FORMULA OF LANGUAGE
     * PROGRAM ::= <COMMAND>+
     * COMMAND ::= <OPERATION> <NUMBER> <NUMBER>
     * OPERATION ::= "ADD" | "SUB" | "MUL" | "DIV"
     * <p>
     * PARSER - CORRECT ORDER
     * LEXER - BREAK INPUT INTO LEXEMES
     */

    class Token {

        /**
         * Token has what fields ? - multiple types: numbers, special chars
         */
        enum TokenType {NUMBER, ADD, SUB, MUL, DIV, END} //END - END THE OPERATION

        TokenType type;
        String value;
    }

    class Lexer {
        String input;

        //accepts input and interprets
        public Lexer(String value) {
            this.input = value;
        }

    }

}
