package data_structures_and_algorithms_CS210.Second_Cohort.week22;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        //"4","13","5","/","+"
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {

        int a, b;
        Stack<Integer> stack = new Stack<>();
//if its not an operator but a num then we will go all the way to the end and then parse string into int and add that int to the stack Stack<Integer>, so in the above example 2, 1 will be in stack
        for (String s : tokens) {
            if (s.equals("+")) {
                //adds the sum of 1 and 2 and removes them from stack not from array(cannot change size)
                stack.add(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a - b);
            } else if (s.equals("*")) {
                stack.add(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a / b);
            } else {
                stack.add(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
