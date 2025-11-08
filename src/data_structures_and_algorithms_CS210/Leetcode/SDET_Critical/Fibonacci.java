package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical;

public class Fibonacci {
    //iterative
    public static int fibonacci(int n) {
        //2, 3, 5, 8, 13
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    //recursive
    public static int fibonacci_rec(int n) {
        if (n <= 1) return n;
        return fibonacci_rec(n - 1) + fibonacci_rec(n - 2);
    }

    //MEMOIZATION - FAST
    private int[] f;

    private int fib_(int n) {
        if (n <= 1) return n;
        if (f[n] == 0) {
            f[n] = fib_(n - 1) + fib_(n - 2);
        }
        return f[n];
    }

    public int fib(int n) {
        f = new int[n + 1]; // 0..n
        return fib_(n);
    }
}

