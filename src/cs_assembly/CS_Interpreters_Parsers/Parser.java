package cs_assembly.CS_Interpreters_Parsers;

import cs_assembly.CS_Interpreters_Parsers.ASTNode;
import cs_assembly.CS_Interpreters_Parsers.NumberNode;
import cs_assembly.CS_Interpreters_Parsers.Token;

import java.lang.reflect.Type;
import java.util.List;

public class Parser {
    private final List<Token> tokens; //going over and creating ASD node, you go to BNF form, what I gave to parser it should follow the rules in BNF
    private int currentPos; //num of tokens, if pos = length we are done
    private Token currentToken;

    public Parser(List<Token> tokens) {
        //insures everything works
        this.tokens = tokens;
        currentPos = 0;
        currentToken = tokens.get(currentPos);
    }

    private ASTNode expression() {

        ASTNode node = term();
        while (currentToken != null && (currentToken.type == Token.Type.PLUS || currentToken.type == Token.Type.MINUS)) {
            Token token = currentToken;
            consume(currentToken.type);
            node = new BinaryOpNode(node, term(), token);
        }
    }

    public ASTNode parse() {
        //will give the top level node to traverse it, we will return the root of the parsed expression if we can parse it
        return term(); //term returns a Tree too, any expression is a term and term is a root of the Tree
    }

    private ASTNode term() {
        //term can be a factor, or factor * or / by smth OR a number
        //WE read a factor and checking if the next term a * or /
        //if next token exists we can only proceed * or / otherwise its an error => Rule 2
        ASTNode factor = factor();
        while (currentToken != null && (currentToken.type == Token.Type.MULTIPLY || currentToken.type == Token.Type.DIVIDE)) {
            Token token = currentToken;
            consume(currentToken.type);
            node = new BinaryOpNode(node, factor(), token);
        }
    }

    private void consume(Type type) {
        if (currentToken.type == type) {
            currentPos++;
            if (currentPos < tokens.size()) {
                currentToken = tokens.get(currentPos);
            } else {
                currentToken = null;

            }
        } else {
            throw new Parserexception("unexpected token " + type);
        }
    }

    private ASTNode factor() {
        //factor is just an expression or a number
        //it has to be a number token and we just return it
        //we are pointing into a token

        //now it could be a paranthesis or a number
        Token token = currentToken;
        if (token.type == Token.Type.NUMBER) {
            consume(Token.Type.NUMBER);
            return new NumberNode(token);
        }

        if (token.type == Type.LPAREN) {
            consume(Tokens.type.LPAREN);
        }
        throw new Parserexception("unexpected token found : " + token);

    }


}
