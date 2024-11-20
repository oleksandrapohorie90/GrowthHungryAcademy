package java_intro.week9;

public class BankAccount{
    private int balance = 1000; // Starting balance
    // Deposit method to add funds
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ", Current Balance: " + balance);
    }
    // Withdraw method to subtract funds
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ", Current Balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal of " + amount);
        }
    }
    // Method to check balance
    public int getBalance() {
        return balance;
    }
}
