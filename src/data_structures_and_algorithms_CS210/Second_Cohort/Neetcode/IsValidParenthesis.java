package data_structures_and_algorithms_CS210.Second_Cohort.Neetcode;

import java.util.Stack;

public class IsValidParenthesis {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                    stack.push(s.charAt(i));
                } else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                    if (!stack.isEmpty()) {
                        char ch = stack.peek();
                        if (s.charAt(i) == ')' && ch == '(') {
                            stack.pop();
                        } else if (s.charAt(i) == '}' && ch == '{') {
                            stack.pop();
                        } else if (s.charAt(i) == ']' && ch == '[') {
                            stack.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false; //in case stack is empty and the char is ']' etc
                    }

                }

            }
            return stack.isEmpty();
        }
    }

}
