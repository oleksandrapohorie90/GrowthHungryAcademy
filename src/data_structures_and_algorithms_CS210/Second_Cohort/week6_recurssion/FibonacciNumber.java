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

    //to speed up we can use common process - the MEMOIZATION(when you store the results that you already computed and reuse them when you try to compute the same value again. So instead of computing the same value again, you just reuse what you have already saved and compute it
    private int[] f;

    /*
    // T(0) = O(1)
    // T(1) = O(1)
    // T(n) = T(n - 1) + T(n - 2)
    // T(n) = O(F(n)) = O(2^n)
    // F(n) = F(n - 1) + F(n - 2)
           <= F(n - 1) + F(n - 1)
           <= G(n - 1) + G(n - 1)
           <= G(n)
           <= 2^n

    // T

    // G(n) = G(n - 1) + G(n - 1)
            = 2 * G(n - 1)
    // G(0) = 1
    // G(n) = 2^n
    */

    // T: O(n)
    // S: O(n)

    private int fib_(int n) {
        if (n <= 1) return n;
        if (f[n] == 0) { // each val f[n] will be computed only once
            f[n] = fib_(n - 1) + fib_(n - 2);
        }
        return f[n];
    }

    public int fib1(int n) {
        f = new int[n + 1]; // 0..n
        return fib_(n);
    }

}
