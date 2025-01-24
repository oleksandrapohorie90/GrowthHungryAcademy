package foundation_pre_course.week13;

import java.util.Stack;

public class ValidParenthesis_MyFav {
    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true
     */
    public static void main(String[] args) {
         // Input: "([{}])"
        // Initial Setup:
        //
        // arduino
        // Copy
        // Edit
        // stack = []
        // Character: (
        //
        // Push ) onto the stack:
        // arduino
        // Copy
        // Edit
        // stack = [')']
        // Character: [
        //
        // Push ] onto the stack:
        // arduino
        // Copy
        // Edit
        // stack = [')', ']']
        // Character: {
        //
        // Push } onto the stack:
        // arduino
        // Copy
        // Edit
        // stack = [')', ']', '}']
        // Character: }
        //
        // stack.pop() removes } (matches ch).
        // arduino
        // Copy
        // Edit
        // stack = [')', ']']
        // Character: ]
        //
        // stack.pop() removes ] (matches ch).
        // arduino
        // Copy
        // Edit
        // stack = [')']
        // Character: )
        //
        // stack.pop() removes ) (matches ch).
        // arduino
        // Copy
        // Edit
        // stack = []
        // End:
        //
        // stack.isEmpty() returns true, so the string is valid.
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        //A stack operates on a "last-in, first-out" (LIFO) principle
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') stack.push(')');
            else if (ch == '[') stack.push(']');
            else if (ch == '{') stack.push('}');
                //If ch is not an opening bracket, it must be a closing bracket.
                // The method checks:
                //Is the stack empty?
                //If yes, it means there's no opening bracket to match the current closing bracket, so the string is invalid.
                //Does the top of the stack match the current closing bracket?
                //If the stack.pop() does not equal ch, the brackets are mismatched, so the string is invalid.
            else if (stack.isEmpty() || stack.pop() != ch) return false;
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        //create an empty stack
        Stack<Character> stack = new Stack<>();

        //loop through every char in the string
        for (char c : s.toCharArray()) {
            //if char is an opening bracket, push(add) it onto the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {//if the char is a closing bracket
                //if the stack is empty, there is no matching opening bracket, so return false
                if (stack.isEmpty()) {
                    return false;
                }

                //otherwise, get the top of the stack and check if it's the matching opening bracket
                char top = stack.peek();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    //if it is, pop the opening bracket from the stack
                    stack.pop();
                } else {//otherwise, the brackets dont match, so return false
                    return false;
                }


            }
        }
        //if the stack is empty, all opening brackets have been closed, so return true
        //Otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }
}
