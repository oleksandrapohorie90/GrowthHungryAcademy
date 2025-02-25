package data_structures_and_algorithms_CS210.Second_Cohort.week6_recurssion;

public class PowX_N_SolutionIsMathy {
    /**
     * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     * Example 1:
     * <p>
     * Input: x = 2.00000, n = 10
     * Output: 1024.00000
     * Example 2:
     * <p>
     * Input: x = 2.10000, n = 3
     * Output: 9.26100
     * Example 3:
     * <p>
     * Input: x = 2.00000, n = -2
     * Output: 0.25000
     * Explanation: 2-2 = 1/22 = 1/4 = 0.25
     * Constraints:
     * <p>
     * -100.0 < x < 100.0
     * -231 <= n <= 231-1
     * n is an integer.
     * Either x is not zero or n > 0.
     * -104 <= xn <= 104
     */

    public double myPow(double x, int n) {
        //first argument to the power of 2nd argument
        //but if exponent n = 0, then you need to return 1, since 2^0 = 1
        long exponent = (long) n;

        // negative n, x^n = (1/x)^(-n)
        // e.g. x^(-7) = (1/x)^7
        if (exponent < 0) {
            exponent = -exponent;
            x = 1 / x;
        }
        return myPow_(x, exponent);
    }

    // T: O(log n) -> you keep decreasing the exponent by a factor of 2 every time, it will take log n divisions until long exponent gets to 0
    // S: O(log n) -> first call x^n, next x^2 ^ exponent/2, third layer - x^4 and exponent will be x^4 ^ exponent/4 and so on
    //all of these layers are stored in the memory
    //we need to know how many layers we will have in recursion, log n layers in the recursion, 2 vars = O(1) space for log n layers of recursion , so total memory complexity = S: O(log n)
    private double myPow_(double x, long exponent) {
        if (exponent == 0) return 1;

        // even n, x^n = (x^2)^(n/2)     = x^(2*(n/2))
        // e.g. x^6 = (x^2)^3 = x^(2*3)

        // odd  n, x^n = (x^2)^(n/2) * x = x^(2*(n/2)) * x = x^(n-1) * x,
        //                                                     because 2 * (n/2) = n - 1 for (n/2) is floored,
        //                                                     i.e. for odd n = 7, n/2 will be 3, not 3.5
        // e.g. x^7 = (x^2)^3 * x = x^(2*3) * x = x^6 * x
        return (exponent % 2 == 0) ? myPow_(x * x, exponent / 2)
                : myPow_(x * x, exponent / 2) * x;
    }

}
