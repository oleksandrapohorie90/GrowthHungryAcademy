package data_structures_and_algorithms_CS210.Second_Cohort.week28_Greedy_Algorithms;

import java.util.Stack;

public class RemoveKth {
    public String removeKdigits(String num, int k) {
        // Number of operations greater than length, we return "0"
        if (num.length() <= k) {
            return "0";
        }

        // k is 0, no need of removing / performing any operation
        if (k == 0) {
            return num;
        }

        StringBuilder res = new StringBuilder(); // Result string
        Stack<Character> s = new Stack<>(); // Character stack

        s.push(num.charAt(0)); // Pushing first character into stack

        for (int i = 1; i < num.length(); ++i) {
            while (k > 0 && !s.empty() && num.charAt(i) < s.peek()) {
                // If k greater than 0 and our stack is not empty and the upcoming digit,
                // is less than the current top, then we will pop the stack top
                --k;
                s.pop();
            }

            s.push(num.charAt(i));

            // Popping preceding zeroes
            if (s.size() == 1 && s.peek() == '0') {
                s.pop();
            }
        }

        // For cases like "456" where every num[i] >= s.peek()
        while (k > 0 && !s.empty()) {
            --k;
            s.pop();
        }

        while (!s.empty()) {
            // Pushing stack top to string
            res.append(s.pop());
        }

        // Reverse the string
        res.reverse();

        if (res.length() == 0) {
            return "0";
        }
        return res.toString();
    }
}
