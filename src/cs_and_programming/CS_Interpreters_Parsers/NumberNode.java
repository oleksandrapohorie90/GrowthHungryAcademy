package cs_and_programming.CS_Interpreters_Parsers;

public class NumberNode extends ASTNode{

        public Token numberToken;
        public final int value;

        public NumberNode (Token numberToken) {
            //all nodes will either be binary operation or a number, each of them is left and right node
            this.numberToken = numberToken;
            this.value = Integer.parseInt(numberToken.value);
        }

    @Override
    public void print(String indent) {
        System.out.println(indent+ "NumberNode{" +
                value +
                '}');
    }
}


