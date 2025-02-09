package data_structures_and_algorithms_CS210.Second_Cohort.week4_binarySearch;

public class SqrtX {

    /**
     * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
     * <p>
     * You must not use any built-in exponent function or operator.
     * <p>
     * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
     * <p>
     * Example 1:
     * <p>
     * Input: x = 4
     * Output: 2
     * Explanation: The square root of 4 is 2, so we return 2.
     * Example 2:
     * <p>
     * Input: x = 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
     */
    public static void main(String[] args) {
        int num = 9;

        System.out.println(mySqrt(num));
    }

    public static int mySqrt(int x) {
// For special cases when x is 0 or 1, return x.
        if (x == 0 || x == 1) return x;

        // Initialize the search range for the square root.
        int left = 1;
        int right = x;
        int answer = -1;

        // Perform binary search to find the square root of x.
        while (left <= right) {
            // Calculate the middle point using "left + (right - left) / 2" to avoid integer overflow.
            int middle = left + (right - left) / 2;

            if ((long) middle * middle > (long) x) {
                // If the square of the middle value is greater than x, move the "right" to the left (mid - 1).
                right = middle - 1;
            } else {
                // If the square of the middle value is less than or equal to x, middle is the best candidate so far, so
                // save it and keep searching for better.
                answer = middle;
                left = middle + 1;
            }
        }

        return answer;
    }
}
