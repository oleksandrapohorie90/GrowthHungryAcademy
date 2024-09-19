package java_intro.week1;

import java.util.HashMap;

public class Fibonacci {

    static HashMap<Integer, Long> cache = new HashMap<>();

    static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        //have you computed this value before? if yes then dont run the code ga
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            long fib = fibonacci(n - 1) + fibonacci(n - 2);
            cache.put(n, fib);
            return fib;
        }
    }

    public static void main(String[] args) {


        //find 100 fib
        for (int i = 0; i <= 10; i++) {
            long fib = fibonacci(i);

            System.out.println("Fib i = " + i + " = " + fib);
        }
    }
}
