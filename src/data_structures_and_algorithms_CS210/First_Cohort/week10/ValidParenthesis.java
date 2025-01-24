package data_structures_and_algorithms_CS210.First_Cohort.week10;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s){

        //create an empty stack
        Stack<Character> stack = new Stack<>();

        //loop through every char in the string
        for(char c: s.toCharArray()){
            //if char is an opening bracket, push(add) it onto the stack
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else {//if the char is a closing bracket
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
