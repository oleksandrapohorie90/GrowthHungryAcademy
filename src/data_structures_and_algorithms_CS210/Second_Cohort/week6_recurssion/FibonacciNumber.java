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

    //brute-force recursion - SLOW
    public int fib(int n) {
        // https://visualgo.net/en/recursion
        if (n <= 1) {
            return n;
        }
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

    // T: O(n) <- very fast
    // S: O(n) <- very fast
    //How long does it take to compute 1 value of a function and multiply it by the nums of values you have to compute. Ex: if you  have to compute f(n), then you need to compute everything from f(1) to f(n), which is n values of this function and each value is going to compute it in O(1)-> sum of 2 prev fibonaccies; Computing a SUM is O(1), any f, you multiply by the numbers of values you have to compute n*1 -> O(n)
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
