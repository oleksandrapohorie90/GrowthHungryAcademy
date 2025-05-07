package data_structures_and_algorithms_CS210.Leetcode.Stack;

import java.util.Stack;

public class ClearDigits {
    public String clearDigits(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!Character.isDigit(current)) {
                stack.push(current);
            } else { //current is a digit

                if (!stack.isEmpty()) {
                    char prev = stack.peek();//check if the ch at the top of stack is a non digit
                    if (!Character.isDigit(prev)) {
                        stack.pop();
                    }
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();

    }
}
