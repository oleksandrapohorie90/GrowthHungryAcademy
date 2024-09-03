package data_structures_and_algorithms_CS210.week19;

public class Recursion_FibonacciNumber {

    //fibonacci relies on computing itself for smaller values, compute itself for the lower values
    //RECURSION - is a property of a function, computing it relies on computing itself
    //F(0) = 0, F(1) = 1
    //F(n) = F(n-1) + F(n-2), for n > 1
    private int[] f;
    //to compute Fib(0) -> O(1)
    //to compute Fib(1) -> O(1)
    //to compute Fib(n) -> T(n-1)+T(n-2) -> the time complexity to compute Nth fibonacci number -> T: O(F(n)) - fibonacci N operations
    //F(n) = F(n-1)+F(n-2)
    //    <= F(n-1)+F(n-1)
    //    <= G(n-1)+G(n-1)
    //    <= G(n)
    //    <= 2^n

    //G(n) = G(n-1) + G(n-1)
    //     = 2 * G * (n-1)
    //G(0)=1
    //G(n)=2^n
    private int fib_(int n) {
        if (n <= 1) {
            return n;
        }
        return fib_(n - 1) + fib(n - 2);
    }

    public int fib(int n) {
        //f = new int[n + 1];
        return fib_(n);
    }

    //common process to speed up is memorization
    //each value f(n) is computed only once
    private int fib_2(int n) {
        if (n <= 1) {
            return n;
        }
        if (f[n] == 0) { //it isnt computed yet
            f[n] = fib_(n - 1) + fib_(n - 2);
        }
        return f[n];
    }

    public int fib2(int n) {
        f = new int[n + 1]; // 0..n
        return fib_(n);
    }
}
