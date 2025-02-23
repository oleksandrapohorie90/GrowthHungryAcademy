package data_structures_and_algorithms_CS210.Second_Cohort.week5_twoPointers_slidingWindow;

public class SumOfSquareNumbers {

    /**
     * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
     * Example 1:
     * <p>
     * Input: c = 5
     * Output: true
     * Explanation: 1 * 1 + 2 * 2 = 5
     * Example 2:
     * <p>
     * Input: c = 3
     * Output: false
     */

    public static void main(String[] args) {
        //we can find a sqrt of 'c', but the int representation of it, bc the numbers a and b can't be bigger then that so it will be our right boundary
        //square the res and then c - res = then we find a sqrt of this num, we square it and then sum up them
        //Two pointers w/ input sorted
    }

    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            long sum = left * left + 0L + right * right;
            if (sum == c) {
                return true;
            }
            if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

}
