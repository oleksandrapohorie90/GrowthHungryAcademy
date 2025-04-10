package data_structures_and_algorithms_CS210.Second_Cohort.week22;

import java.util.Stack;

public class ReversedString {

    public static String reverseStrWithStack(String str){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

// Step 1: Push all characters onto the stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

// Step 2: Pop characters and build reversed string
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

// Step 3: Return result as a string
        return sb.toString();
    }
}
