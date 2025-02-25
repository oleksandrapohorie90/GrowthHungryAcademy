package data_structures_and_algorithms_CS210.Second_Cohort.week6_recurssion;

public class FibonacciNumber {

    public static void main(String[] args) {
        //Recursion is a property of a function when computing it, relies on computing itself

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
        //It is an exponential function, computing n-th fib number is proportional to n-th fib number, its computation time will be proportional to T(n) = O(F(n)) = O(2^n)
        //F(2) = F(1) + F(0) = 1 + 0 = 1.

        //in this proble the restriction is that n is <= 30, so it will be 2^30 = 1 billion operations, so it will timeout if we leave the first solution

        System.out.println(fib(n));

    }

    public static int fib(int n) {
        if (n <= 1) return n;
        //you need to compute again fib function but for smaller parameters
        return fib(n - 1) + fib(n - 2);
    }

}
