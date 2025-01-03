package java_intro.week10;
import java.util.concurrent.locks.ReentrantLock;

public class Inventory {
    private int stock = 100;
    private final ReentrantLock lock = new ReentrantLock();
    public void addStock(int quantity) {
        lock.lock();
        try {
            stock += quantity;
            System.out.println(Thread.currentThread().getName() + " added stock. Current stock: " + stock);
        } finally {
            lock.unlock();
        }
    }
    public void removeStock(int quantity) {
        lock.lock();
        try {
            if (stock >= quantity) {
                stock -= quantity;
                System.out.println(Thread.currentThread().getName()
                        + " removed stock. Current stock: " + stock);
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " insufficient stock.");
            }
        } finally {
            lock.unlock();
        }
    }
}
