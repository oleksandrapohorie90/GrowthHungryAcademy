package data_structures_and_algorithms_CS210.Leetcode.Stack;

import java.util.Stack;

public class RemoveAllAdjucentDupInStr {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i); //a
            if (!stack.isEmpty()) {
                char prev = stack.peek();
                if (current == prev) {
                    stack.pop();
                    continue;
                }
            }

            stack.push(current);
        }
        StringBuilder sb = new StringBuilder();

        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
