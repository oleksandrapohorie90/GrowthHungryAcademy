package java_intro.week10.HW_10;

import java_intro.week10.Inventory;
import java_intro.week10.ReentrantLockExample;

import java.util.concurrent.locks.ReentrantLock;

public class SafeCounter {
    private int count;
    private final ReentrantLock lock = new ReentrantLock();

    private void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    private void decrement() {
        lock.lock();
        try {
            count--;
        } finally {
            lock.unlock();
        }
    }

    private int getValue() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SafeCounter counter = new SafeCounter();

        Runnable incrementTask = () -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
                System.out.println("Incremented: " + counter.getValue());
            }
        };

        Runnable decrementTask = () -> {
            for (int i = 0; i < 5; i++) {
                counter.decrement();
                System.out.println("Decremented: " + counter.getValue());
            }
        };

        //The Thread class expects a Runnable or Callable object, not a String.
        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(decrementTask);
        Thread t3 = new Thread(incrementTask);
        t1.start();
        t2.start();
        t3.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final counter value
        System.out.println("Final Counter Value: " + counter.getValue());
    }
}
