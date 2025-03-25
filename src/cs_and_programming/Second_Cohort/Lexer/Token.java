package cs_and_programming.Second_Cohort.Lexer;

public class Token {
    public String type;
    public String value;
//    Lexer - a word scanner for DSL
//    A lexer (also called a tokenizer) reads your code and breaks it into small parts called tokens. Think of tokens like labels for words in a sentence
    public Token(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String toString() {
        return "(" + type + ", " + value + ")";
    }
}

