package java_intro.week9.practical_9;

import java.util.ArrayList;
import java.util.List;

public class BankSimulation {
    public static void main(String[] args) {
// Create shared bank account
        BankAccount account = new BankAccount();
        List<Thread> customers = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            customers.get(i).start();
            customers.add(new Thread(new Customer(account), "Customer" + i));
        }
        try {
            for (int i = 0; i < 100; i++) {
                customers.get(i).join();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
// Create multiple customer threads
        Thread customer1 = new Thread(new Customer(account), "Customer1");
        Thread customer2 = new Thread(new Customer(account), "Customer2");
        Thread customer3 = new Thread(new Customer(account), "Customer3");
// Start each customer thread
        customer1.start();
        customer2.start();
        customer3.start();
// Wait for threads to finish
        try {
            customer1.join();
            customer2.join();
            customer3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
// Display the final balance
        System.out.println("Final Balance: " + account.getBalance());
    }
}
