package data_structures_and_algorithms_CS210.Second_Cohort.week22_Stack;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //check all options for opening brackets
            if (c == '(' || c == '[' || c == '{') {
                //if exists we want it and push in
                stack.push(c);
            } else {
                //if the char is closing bracket
                //if the stack is empty, it means there is no corresponding opening brackets, so return false
                //ex: ")" or "())" - both invalid
                if (stack.isEmpty()) {
                    return false;
                }
                //otherwise the stack is not empty and there is some bracket at the top of the stack, lets get it
                char top = stack.peek();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    //if there is a matching bracket - remove, keep removing
                    stack.pop();
                } else {
                    //otherwise there is no matching bracket so return false
                    return false;
                }
            }
        }

        //if stack is empty - you matched all of the opening brackets if at the end stack is empty return true

        return stack.isEmpty();
    }
}
