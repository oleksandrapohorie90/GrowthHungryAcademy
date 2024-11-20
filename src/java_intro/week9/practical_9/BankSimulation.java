package java_intro.week9.practical_9;

public class BankSimulation {
    public static void main(String[] args) {
// Create shared bank account
        BankAccount account = new BankAccount();
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
