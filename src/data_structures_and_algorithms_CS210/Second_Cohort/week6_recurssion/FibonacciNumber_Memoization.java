package data_structures_and_algorithms_CS210.Second_Cohort.week6_recurssion;

public class FibonacciNumber_Memoization {
    //memoization - when we save the result of calculating a certain fib number, so then later on when we need to calculate that exact same fib number again we can just look up that value that we already calculated instead of redoing all those calculations all over again

    public static void main(String[] args) {
        /**
         * fib sequence is a seq of nums that starts with 0 and 1 and each number after that is a sum of previous 2 numbers
         * 0  1  1  2  3  5  8  13  21 34 ...
         *  +  +  +  +  +  +  +  +  +  +
         */
        int n2 = 6; //<= 8, the 6th fib number is the 5th fib number + 4th fib number
        //f(n) = f(n-1) + f(n-2)
        fibonacci(n2);
    }
    private static long fibonacci(int n2){
        //base case - a case where the condition is met and it stops/prevents recursive call, each recursive algorithms needs a base case to prevent it from recursing infinitely
        if(n2<=1){
            return n2;
        }
        return (fibonacci(n2-1)+fibonacci(n2-2));
    }
}
