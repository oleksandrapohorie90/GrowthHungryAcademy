package data_structures_and_algorithms_CS210.Second_Cohort.week22_Stack;

public class MyStack {

    private int[] stack;
    private int top;
    private int capacity;

    public MyStack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1; // nothing added yet
    }

    //push
    public void push(int value) {

        if (top == capacity - 1) {
            System.out.println("Stack overflow. Cannot push " + value);
            return;
        }
        stack[++top] = value;

    }

    //pop
    public int pop(int value) {

        if (top == -1) {
            System.out.println("Stack underflow. Cannot pop " + value);
            return -1;
        }
        return stack[top--] = value;

    }

    //peek
    public int peek() {
        if (top == -1) {
            System.out.println("Stack underflow. Nothing to peek.");
            return -1;
        }
        return stack[top];
    }

    //isEmpty
    public boolean isEmpty() {
        return top == -1;
    }

    /*
    public int size() {
    return stack.length;
}
This returns the total capacity of the array (how many items the stack could hold), not how many are currently in the stack.

That’s like saying:

“This parking lot has 10 spaces” — instead of
“There are 3 cars parked here right now.”
     */
    //since top=-1 we have to do +1
    public int size() {
        return top + 1;
    }


}
