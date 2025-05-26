package data_structures_and_algorithms_CS210.Leetcode.Queue_Deque;

public class DesignCircularDeque {
    int[] array;
    int front;
    int rear;
    int counter;
    int length;

    public DesignCircularDeque(int k) {
        array = new int[k];
        counter = 0;
        length = k;
        front = 0;
        rear = k - 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + length) % length;
        array[front] = value;
        counter++;
        return true;

    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % length;
        array[rear] = value;
        counter++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        front = (front + 1) % length;
        counter--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        rear = (rear - 1 + length) % length;
        counter--;
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return array[front];
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return array[rear];

    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == length;
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
