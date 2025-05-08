package data_structures_and_algorithms_CS210.Leetcode.Stack;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        //(])

        //st
        //(

        //create an empty stack
        Stack<Character> stack = new Stack<>();

        //loop through every char in the string
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false; //in case ')' comes first, dont check anymore
                } else {
                    char prev = stack.peek(); //(
                    if ((prev == '(' && c == ')') || (prev == '{' && c == '}') || (prev == '[' && c == ']')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}

