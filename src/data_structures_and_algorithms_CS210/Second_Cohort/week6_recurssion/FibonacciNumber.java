package data_structures_and_algorithms_CS210.Second_Cohort.week6_recurssion;

public class FibonacciNumber {

    public static void main(String[] args) {
        /** Next fib num is the sum of previous 2 nums
         * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
         *
         * F(0) = 0, F(1) = 1
         * F(n) = F(n - 1) + F(n - 2), for n > 1.
         * Given n, calculate F(n).
         *
         * Example 1:
         *
         * Input: n = 2
         * Output: 1
         * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
         *
         */
        int n = 2;
        //F(2) = F(1) + F(0) = 1 + 0 = 1.
        System.out.println(fib(n));

    }

    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

}
