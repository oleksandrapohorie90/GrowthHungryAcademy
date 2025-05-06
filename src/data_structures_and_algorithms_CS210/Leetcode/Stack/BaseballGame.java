package data_structures_and_algorithms_CS210.Leetcode.Stack;

import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<String> stack = new Stack<>();
        int prev = 0;
        for (int i = 0; i < operations.length; i++) {
            if (!operations[i].equals("C") && !operations[i].equals("D") && !operations[i].equals("+")) {
                stack.push(operations[i]);
            }
            if (operations[i].equals("C")) {
                stack.pop();
            } else if (operations[i].equals("D")) {
                prev = Integer.parseInt(stack.peek());
                stack.push(String.valueOf(prev * 2));
            } else if (operations[i].equals("+")) {
                int d2 = Integer.parseInt(stack.pop());
                int d1 = Integer.parseInt(stack.peek());
                int d3 = d1 + d2;
                stack.push(String.valueOf(d2));
                stack.push(String.valueOf(d3));
            }
        }
        int sum = 0;
        for (int i = 0; i < stack.size(); i++) {
            sum += Integer.parseInt(stack.get(i));
        }

        return sum;
    }
}
