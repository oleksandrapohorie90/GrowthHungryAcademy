package java_intro.week9.practical_9;

import java.util.Random;

public class Customer implements Runnable {
    private BankAccount account;
    private Random random = new Random();
    // Constructor
    public Customer(BankAccount account) {
        this.account = account;
    }
    // Run method for random deposit and withdrawal operations
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) { // Each customer performs 5 random transactions
            int choice = random.nextInt(2);
            int amount = random.nextInt(100) + 1; // Random amount between 1 and 100
            if (choice == 0) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
            try {
                Thread.sleep(100); // Simulate transaction processing time
            } catch (InterruptedException e) {
                System.out.println("Transaction interrupted");
            }
        }
    }
}
