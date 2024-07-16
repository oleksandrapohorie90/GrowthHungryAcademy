package data_structures_and_algorithms.week10;



public class MinStack {
    //void push(int val) pushes element val onto the stack
    //void pop() removes the element on the top of the stack
    // int top() gets the top element of the stack
    //int getMin() retrieves the min element in the stack
    private Node head;

    public void push(int x) {
        if (head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top(){
        return head.val;
    }

    public int getMin(){
        return head.val;
    }

    private class Node{//singly-linked list
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next){
            this.val=val;
            this.min=min;
            this.next=next;
        }
    }

}
