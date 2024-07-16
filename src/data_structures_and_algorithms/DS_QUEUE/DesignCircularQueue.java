package data_structures_and_algorithms.DS_QUEUE;

public class DesignCircularQueue {
    int[] queue;
    int front,rear,maxSize,size;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public DesignCircularQueue(int k) {
        queue = new int[k];
        maxSize = k;
        size = 0;
        front = 0;
        rear = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size < maxSize){
            rear = ++rear % maxSize;
            queue[rear] = value;
            size++;
            return true;
        }
        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size > 0){
            front = ++front % maxSize;
            size--;
            return true;
        }
        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return size > 0 ? queue[front] : -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return size > 0 ? queue[rear] : -1 ;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == maxSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

