package data_structures_and_algorithms_CS210.Second_Cohort.week28_Greedy_Algorithms;

import java.util.Stack;

public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        //what if asterisks appear before the closing bracket
        Stack<Integer> left_indices = new Stack<>();
        Stack<Integer> asterisk_indices = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left_indices.push(i);
            } else if (c == '*') {
                asterisk_indices.push(i);
            } else {
                if (!left_indices.isEmpty()) {
                    left_indices.pop(); //means there is smth we can match it with
                } else if (!asterisk_indices.isEmpty()) {
                    asterisk_indices.pop();
                } else {
                    return false; //this closing bracket cant be matched
                }
            }
        }
        while (!left_indices.isEmpty()) {
            //can we match the left indices ?
            if (!asterisk_indices.isEmpty() && left_indices.peek() < asterisk_indices.peek()) {
                left_indices.pop();
                asterisk_indices.pop();
            } else {
                return false;
            }
        }
        return true;
    }
}
