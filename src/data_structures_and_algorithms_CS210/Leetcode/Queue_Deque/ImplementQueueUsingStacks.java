package data_structures_and_algorithms_CS210.Leetcode.Queue_Deque;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    //Queue: FIFO
    //push -> [1, 2, 3], pop -> 1, peek -> 1
    Stack<Integer> stack2;

    //Stack: LIFO
    //push -> [1, 2, 3], pop -> 3, peek -> 3
    Stack<Integer> stack1;

    public ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    //stack1 -> 1,2,3
    //stack2 -> 3,2,1
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }

        return stack2.peek();

    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

